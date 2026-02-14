import { NavLink } from "react-router-dom";
import {useEffect, useState} from "react";
import axios from "axios";

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

    const LogInOut = () => {
        window.location.href = isAuthenticated ? "/oauth2/sign_out" : "/oauth2/start";
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