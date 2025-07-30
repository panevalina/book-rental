import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import HomePage from "./pages/HomePage/HomePage"; // <- патеката до твојата HomePage компонента
import BooksPage from "./pages/BooksPage/BooksPage";
import AuthorsPage from "./pages/AuthorsPage/AuthorsPage";

function App() {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<HomePage />} />
                <Route path="/books" element={<BooksPage />} />
                <Route path="/authors" element={<AuthorsPage />} />
            </Routes>
        </Router>
    );
}

export default App;
