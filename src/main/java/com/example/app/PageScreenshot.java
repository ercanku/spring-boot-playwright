package com.example.app;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class PageScreenshot {
    public void fetch() throws Exception {
        Playwright playwright = Playwright.create();
        List<BrowserType> browserTypes = Arrays.asList(
                playwright.chromium(),
                playwright.webkit(),
                playwright.firefox()
        );

        System.out.println("Playwright started");
        for (BrowserType browserType : browserTypes) {
            Browser browser = browserType.launch();
            BrowserContext context = browser.newContext(
                    new Browser.NewContextOptions().withViewport(800, 600));
            Page page = context.newPage();
            page.navigate("http://whatsmyuseragent.org/");
            page.screenshot(new Page.ScreenshotOptions().withPath(Paths.get("screenshot-" + browserType.name() + ".png")));
            browser.close();
        }
        playwright.close();
    }
}