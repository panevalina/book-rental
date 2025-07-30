import React from 'react';
import { Link } from "react-router-dom";
import { AppBar, Box, Button, IconButton, Toolbar, Typography } from "@mui/material";
import MenuIcon from '@mui/icons-material/Menu';
import "./Header.css";

const pages = [
    { path: "/", name: "Home" },
    { path: "/books", name: "Books" },
    { path: "/authors", name: "Authors" },
];


const Header = () => {
    return (
        <Box>
            <AppBar position="static">
                <Toolbar>
                    <IconButton
                        size="large"
                        edge="start"
                        color="inherit"
                        aria-label="menu"
                        sx={{ mr: 2 }}
                    >
                        <MenuIcon />
                    </IconButton>
                    <Typography variant="h6" component="div" sx={{ mr: 3 }}>
                        E-SHOP
                    </Typography>
                    <Box sx={{ flexGrow: 1, display: { xs: "none", md: "flex" } }}>
                        {pages.map((page) => (
                            <Button
                                key={page.name}
                                component={Link}
                                to={page.path}
                                sx={{
                                    my: 2,
                                    color: "white",
                                    display: "block",
                                    textDecoration: "none"
                                }}
                            >
                                {page.name}
                            </Button>
                        ))}
                    </Box>
                    <Button color="inherit">Login</Button>
                </Toolbar>
            </AppBar>
        </Box>
    );
};

export default Header;
