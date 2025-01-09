package pages;

import org.sparkrock.utils.ConfigurationReader;
import org.sparkrock.utils.Driver;


public class BasePage {
    public static HomePage homePage = new HomePage();
    public static InventoryPage inventoryPage = new InventoryPage();

    public static String getPageNameFromCurrentUrl() {
        try {
            String CurrentPageUrl = Driver.getDriver().getCurrentUrl(); if (CurrentPageUrl.split("com/").length == 1) {
                return "";
            } return CurrentPageUrl.split(".com/")[1].split(".html")[0];
        } catch (Exception e) {
            throw new RuntimeException("Error in BasePage.getCurrentPage: " + e.getMessage(), e);
        }
    }

    public static IPage getPage(String pageName) {
        return switch (pageName.toLowerCase()) {
            case "" -> homePage; case "inventory" -> inventoryPage; default -> {
                System.out.println("Page not found: " + pageName + " in " + BasePage.class.getSimpleName()); yield null;
            }
        };
    }

    public static String getThePageUrl(String pageName) {
        try {
            String url = ConfigurationReader.get("baseUrl"); switch (pageName.toLowerCase()) {
                case ("home page"):
                    url += "/"; ; break;
                case ("inventory page"):
                    url += "/inventory.html"; break;
                default:
                    throw new IllegalArgumentException("Page \"" + pageName + "\" was not configured.");
            } return url;
        } catch (Exception e) {
            throw new RuntimeException("Error in BasePage.goToPageUrl: " + e.getMessage(), e);
        }
    }

}
