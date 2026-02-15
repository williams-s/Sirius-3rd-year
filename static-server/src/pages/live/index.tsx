import React,{useState, useEffect} from "react";
import type {MatchResponse} from "../../types/generated/MatchResponse.ts";

export const LiveIndex : React.FC = () => {
    const [matchs, setMatchs] = useState<MatchResponse[]>();
    useEffect(() => {

    }, []);

    return (
        <div>
            Match en directs
        </div>
    );
}