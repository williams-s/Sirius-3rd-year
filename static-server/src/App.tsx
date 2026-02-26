import { BrowserRouter, Routes, Route } from "react-router-dom";
import HomePage from "./pages/HomePage.tsx";
import {LiveIndex} from "./pages/live";
import {Layout} from "./Layout.tsx";
import {LiveMatchPage} from "./pages/live/liveMatchPage.tsx";
import {MatchesIndex} from "./pages/matches";
import {MatchByTeamPage} from "./pages/matches/matchByTeamPage.tsx";
import {PlayersIndex} from "./pages/players";
import {PlayersByTeamPage} from "./pages/players/playersByTeamPage.tsx";

function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route element={<Layout />}>
                    <Route path="/" element={<HomePage/>} />
                    <Route path="/players" element={<PlayersIndex/>}/>
                    <Route path="/players/:teamId" element={<PlayersByTeamPage/>}/>
                    <Route path="/matches" element={<MatchesIndex/>}/>
                    <Route path="/matches/:teamId" element={<MatchByTeamPage/>}/>
                    <Route path="/live/" element={<LiveIndex/>} />
                    <Route path="/live/:matchId" element={<LiveMatchPage />} />
                </Route>
            </Routes>
        </BrowserRouter>
    );
}

export default App;
