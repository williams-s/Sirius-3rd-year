import React, { useEffect, useState } from "react";
import {ConnectToWebSocketSTOMP} from "../utils/websocketConnection.ts";

export interface Match {
    idMatch: number;
    homeTeam: string;
    awayTeam: string;
    homeScore: number;
    awayScore: number;
    date: string;
    status: "LIVE" | "FINISHED" | "SCHEDULED";
    competition: string;
}


const HomePage: React.FC = () => {
    const [matches, setMatches] = useState<Match[]>([]);
    useEffect(() => {
        const client = ConnectToWebSocketSTOMP();

        client.onConnect = () => {
            console.log("STOMP connecté");

            /*client.subscribe("/user/queue/matchHistory", (message) => {
                try {
                    console.log("Here ! ")
                    const data: Match[] = JSON.parse(message.body);
                    console.log("Received match history:", data);
                    setMatches(data);
                } catch (err) {
                    console.error("Erreur parsing STOMP:", err);
                }
            });*/
            client.subscribe("/topic/matchHistory", (message) => {
                console.log("Message reçu:", message.body);
            });
        };

        client.onStompError = (frame) => {
            console.error("STOMP error:", frame);
        };

        client.activate();

        return () => {
            client.deactivate();
        };
    }, []);

    const liveMatch = matches.find((m) => m.status === "LIVE");
    const recentMatches = matches.filter((m) => m.status === "FINISHED").slice(0, 5);

    return (
        <div className="min-h-screen bg-gradient-to-b from-green-100 to-green-300 p-6 flex flex-col items-center">
            <h1 className="text-4xl font-extrabold text-yellow-700 mb-6 drop-shadow-lg">
                Football Dashboard
            </h1>

            {liveMatch ? (
                <div className="w-full max-w-xl bg-white rounded-lg shadow p-4 mb-6 border-l-8 border-red-500 animate-pulse">
                    <h2 className="text-xl font-bold text-red-600 mb-2">Live Match</h2>
                    <p className="text-lg font-semibold">
                        {liveMatch.homeTeam} {liveMatch.homeScore} - {liveMatch.awayTeam} {liveMatch.awayScore}
                    </p>
                    <p className="text-gray-500 text-sm">Started at: {new Date(liveMatch.date).toLocaleTimeString()}</p>
                </div>
            ) : (
                <p className="text-gray-700 mb-6">Aucun match en cours</p>
            )}

            <div className="w-full max-w-xl">
                <h2 className="text-2xl font-bold text-blue-600 mb-4">Recent Matches</h2>
                <div className="space-y-4">
                    {recentMatches.map((m) => (
                        <div key={m.idMatch} className="bg-white rounded-lg shadow p-4 flex justify-between items-center border-l-4 border-blue-500">
              <span className="font-semibold text-gray-800">
                {m.homeTeam} {m.homeScore} - {m.awayTeam} {m.awayScore}
              </span>
                            <span className="text-gray-500 text-sm">{new Date(m.date).toLocaleDateString()}</span>
                        </div>
                    ))}
                    {recentMatches.length === 0 && <p className="text-gray-500">Aucun match récent</p>}
                </div>
            </div>
        </div>
    );
};

export default HomePage;
