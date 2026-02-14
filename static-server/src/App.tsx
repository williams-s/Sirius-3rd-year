import { BrowserRouter, Routes, Route } from "react-router-dom";
import HomePage from "./pages/HomePage.tsx";
import {HeatMapPage} from "./pages/live/heatMapPage.tsx";
import {LiveIndex} from "./pages/live";
import {Layout} from "./Layout.tsx";
import {LiveMatchPage} from "./pages/live/liveMatchPage.tsx";

function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route element={<Layout />}>
                    <Route path="/" element={<HomePage/>} />
                    <Route path="/live/" element={<LiveIndex/>} />
                    <Route path="/live/:matchId" element={<LiveMatchPage />} />
                    <Route path="/live/:matchId/heat-map/:playerId" element={<HeatMapPage />} />
                </Route>
            </Routes>
        </BrowserRouter>
    );
}

export default App;
