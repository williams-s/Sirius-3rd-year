import { BrowserRouter, Routes, Route } from "react-router-dom";
import HomePage from "./pages/HomePage.tsx";
import {HeatMapPage} from "./pages/live/heatMap.tsx";
import {LiveMatchPage} from "./pages/live";

function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<HomePage />} />
                <Route path="/live/:matchId" element={<LiveMatchPage/>}/>
                <Route path="/live/:matchId/heat-map/:playerId" element={<HeatMapPage/>}/>
            </Routes>
        </BrowserRouter>
    );
}

export default App;
