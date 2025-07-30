import { useEffect, useState } from "react";
import authorRepository from "../repository/authorRepository";

const useAuthors = () => {
    const [authors, setAuthors] = useState([]);

    useEffect(() => {
        authorRepository.findAll()
            .then(res => setAuthors(res.data))
            .catch(err => console.log(err));
    }, []);

    return authors;
};

export default useAuthors;
