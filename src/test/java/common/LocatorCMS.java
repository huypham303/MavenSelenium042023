package common;

public class LocatorCMS {
    //Login Page
    public static String welcomeLoginText = "//h1[normalize-space()='Welcome to Active eCommerce CMS']";
    public static String inputEmail = "//input[@id='email']";
    public static String inputPassword = "//input[@id='password']";
    public static String loginButton = "//button[normalize-space()='Login']";

    //Dashboard Page
    public static String logoAnhTester = "//img[@alt='Active eCommerce CMS']";
    //Menu Category
    public static String sidebarProducts = "//span[normalize-space()='Products']";
    public static String categoryList = "//span[normalize-space()='Category']";
    public static String addNewCategoryButton = "//a[@class='btn btn-primary']";
    public static String nameTxtCategory = "//input[@id='name']";
    public static String saveButtonCategory = "//button[normalize-space()='Save']";
    public static String searchCategory = "//input[@id='search']";
    public static String getNameCategory = "//tbody/tr/td[2]";
    public static String editCategoryButton = "(//a[@title='Edit'])[1]";
    public static String deleteCategoryButtonOut = "(//a[@title='Delete'])[1]";
    public static String deleteCategoryPopupTitle = "//h4[normalize-space()='Delete Confirmation']";
    public static String deleteCategoryButtonIn = "//a[@id='delete-link']";
    public static String nothingFoundCategoryMess = "//td[normalize-space()='Nothing found']";


}
