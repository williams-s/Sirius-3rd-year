import { Outlet } from "react-router-dom";
import {Navbar} from "./Navbar.tsx";

export const Layout = () => {
    return (
        <div className="flex flex-col h-screen">
            <Navbar />
            <main className="flex-1 h-full overflow-hidden">
                <Outlet />
            </main>
        </div>
    );
};