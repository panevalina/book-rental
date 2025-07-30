import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import BooksPage from './ui/pages/BooksPage';
import AuthorsPage from './ui/pages/AuthorsPage';
import CountriesPage from './ui/pages/CountriesPage';
import HomePage from './ui/pages/homePage/HomePage';

const App = () => {
    return (
        <Router>
                <Routes>
                    <Route path="/" element={<HomePage />} />
                    <Route path="/books" element={<BooksPage />} />
                    <Route path="/authors" element={<AuthorsPage />} />
                    <Route path="/countries" element={<CountriesPage />} />
                </Routes>
        </Router>
    );
};

export default App;
