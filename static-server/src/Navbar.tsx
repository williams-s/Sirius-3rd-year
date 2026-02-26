import {NavLink} from "react-router-dom";
import {useEffect, useState} from "react";
import axios from "axios";
import {ConnectToWebSocketSTOMP} from "./utils/websocketConnection.ts";
import {getMyClub} from "./api/clubApi.ts";
import type {MatchResponse} from "./types/generated/MatchResponse.ts";
import toast from "react-hot-toast";
import {MatchCardHeader} from "./components/MatchDetailsComponent.tsx";

const NAV_ITEMS = [
    { label: "Club", path: "/club" },
    { label: "Joueurs", path: "/players" },
    { label: "Matchs", path: "/matches" },
    { label: "Matchs en direct", path: "/live"}
];

export const Navbar = () => {
    const [isAuthenticated, setIsAuthenticated] = useState(false);


    useEffect(() => {
        axios.get("/oauth2/userinfo")
            .then(() => setIsAuthenticated(true))
            .catch(() => setIsAuthenticated(false));
    }, []);

    useEffect(() => {
        if (isAuthenticated){
            const subForNotif = async () => {
                const clubData = await getMyClub();
                //const clubData = {clubId : 2};
                if (clubData) {
                    const client = ConnectToWebSocketSTOMP();
                    client.onConnect = () => {
                        client.subscribe(`/topic/notif-live-match/${clubData.clubId}`,(message) => {
                            try {
                                const match : MatchResponse = JSON.parse(message.body);
                                toast.custom((t) => (
                                    <div
                                        onClick={() => {
                                            window.location.href = `/live/${match.idMatch}`;
                                            toast.dismiss(t.id);
                                        }}
                                        className={`cursor-pointer flex flex-col gap-1 px-4 py-3 rounded-lg border border-blue-500 bg-slate-800 text-white`}
                                    >
                                        <div className="flex items-center gap-2">
                                            <MatchCardHeader matchStatus={match.status}/>
                                        </div>
                                        <span>{match.homeTeam.name} vs {match.awayTeam.name}</span>
                                        <span>{match.homeScore} - {match.awayScore}</span>
                                        <span className="text-slate-400 text-xs">{match.competition} - {match.matchDay}</span>
                                    </div>
                                ), { duration: 6000 });
                            } catch (e) {
                                console.error(e);
                            }
                        });
                    }
                    client.activate();
                }
            }
            subForNotif();
        }
    }, [isAuthenticated]);

    const LogInOut = async () => {
        if (isAuthenticated) {
            try {
                await axios.get("/oauth2/sign_out", {
                    maxRedirects: 0,
                    validateStatus: (status) => status === 302 || status === 200
                });
            } catch (e) {

            }
            window.location.href = "https://172.31.249.162/realms/cm-realm/protocol/openid-connect/logout" +
                "?client_id=portal" +
                "&post_logout_redirect_uri=" + encodeURIComponent("https://172.31.249.162");
        } else {
            window.location.href = "/oauth2/start";
        }
    };

    return (
        <nav className="w-full flex items-center justify-between px-6 h-12 bg-slate-900 border-b border-slate-700">

        <span className="text-blue-400 font-bold uppercase tracking-widest">Club Manager</span>

        <div className="flex items-center gap-6">
            {NAV_ITEMS.map(({ label, path }) => (
                    <NavLink key={path} to={path} className={({ isActive }) =>
                        `text-xs font-semibold uppercase tracking-widest transition-colors ${
                            isActive ? "text-white border-b border-blue-400 pb-0.5" : "text-slate-400 hover:text-white"}`
                    }>
                        {label}
                    </NavLink>
            ))}
        </div>

        <button onClick={LogInOut}
        className={`text-xs font-semibold uppercase tracking-widest transition-colors ${
            isAuthenticated ? "text-red-400 hover:text-red-300" : "text-blue-400 hover:text-blue-300"
        }`}
        >
            {isAuthenticated ? "Se déconnecter" : "Se connecter"}
        </button>

        </nav>
    );
};