import React, { useEffect, useState } from "react";
import {ConnectToWebSocketSTOMP} from "../utils/websocketConnection.ts";


const HomePage: React.FC = () => {

    return (
        <div className="flex items-center justify-center h-screen w-screen">
           <img src="/images/club_manager_logo.png" alt="Club Manager Logo" width={window.innerWidth/3}/>
        </div>
    );
};

export default HomePage;
