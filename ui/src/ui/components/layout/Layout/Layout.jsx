import React from 'react';
import { Box, Container } from "@mui/material";
import Header from "../Header/Header.jsx";
import { Outlet } from "react-router-dom";
import "./Layout.css";

const Layout = () => {
    return (
        <Box>
            <Header />
            <Container maxWidth="xl" sx={{ my: 2 }}>
                <Outlet />
            </Container>
        </Box>
    );
};

export default Layout;
