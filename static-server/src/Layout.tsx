import { Outlet } from "react-router-dom";
import {Navbar} from "./Navbar.tsx";
import {Toaster} from "react-hot-toast";

export const Layout = () => {
    return (
        <div className="flex flex-col h-screen">
            <Toaster position="top-right" />
            <Navbar />
            <main className="flex-1 h-full overflow-hidden">
                <Outlet />
            </main>
        </div>
    );
};