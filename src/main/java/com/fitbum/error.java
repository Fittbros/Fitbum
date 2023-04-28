package com.fitbum;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class error implements ErrorController {

        private final static String PATH = "/error";
        @RequestMapping(PATH)
        @ResponseBody
        public String getErrorPath() {

            return "<div class=\"container-fluid\">\n" +
                    "                    <div class=\"text-center mt-5\">\n" +
                    "                        <div class=\"error mx-auto\" data-text=\"404\">\n" +
                    "                            <p class=\"m-0\">404</p>\n" +
                    "                        </div>\n" +
                    "                        <p class=\"text-dark mb-5 lead\">Page Not Found</p>\n" +
                    "                        <p class=\"text-black-50 mb-0\">It looks like you found a glitch in the matrix...</p><a href=\"/\">← Back to Dashboard</a>\n" +
                    "                    </div>";
        }

    }

