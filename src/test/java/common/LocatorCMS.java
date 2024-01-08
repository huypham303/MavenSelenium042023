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

    // Category List
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

    // add New Category Page
    public static String addNewProductSidebar = "//span[normalize-space()='Add New Product']";
    public static String addNewProductTitle = "//h5[normalize-space()='Product Information']";
    public static String addNewProductName = "//input[@placeholder='Product Name']";
    public static String categoryType = "//div[@id='category']//div[@class='dropdown bootstrap-select form-control aiz-']//button";
    public static String categoryTypeSearch = "(//input[@aria-label='Search'])[1]";
    public static String categoryTag = "//span[@role='textbox']";
    public static String categoryTagName = "//tags[@role='tagslist']";
    public static String quantity = "//input[@name='min_qty']";
    public static String unit = "//input[@placeholder='Unit (e.g. KG, Pc etc)']";
    public static String activeColor = "//div[@class='col-md-1']//span";
    public static String colorList = "//div[@class='dropdown bootstrap-select show-tick form-control aiz- dropup']//button";
    public static String colorSearch = "(//input[@aria-label='Search'])[3]";
    public static String unitPrice = "//input[@placeholder='Unit price']";
    public static String discount = "//input[@placeholder='Discount']";
    public static String saveAndPublishButton = "//button[normalize-space()='Save & Publish']";
    public static String thumbnailImages= "(//div[@class='input-group'])[2]//div[2]";
    public static String seachImages = "//input[@placeholder='Search your files']";
    public static String itemImages = "(//div[@title='Cosy.png'])[2]";
    public static String addFileImages = "//button[normalize-space()='Add Files']";


}
