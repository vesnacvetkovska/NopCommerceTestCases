package testData;

public class TestData {
	
	
	//Search data
	public String nike = "Nike";
	public String sony = "Sony";
	public String hp = "HP";
	public String noProductsWereFound = "No products were found that matched your criteria.";
	public String minCharForSearchMsg = "Search term minimum length is 3 characters";
	
	//log in Data
	public String validEmail = "johndoe@email.com";
	public String inValidEmail = "johndoe@@email.com";
	public String validPass = "123456";
	public String differentPass = "123457";
	public String invalidPass = "12345";
	public String emptyEmail = "";
	public String emptyPassword = "";
	public String emptyLastName = "";
	public String changedEmailAdress = "legendone@email.com";
	public String validConffirmPassword = "123456";
	public String errorMsgLogin = "Login was unsuccessful. Please correct the errors and try again.\n"
			+ "No customer account found";
	public String errorMsgEmailField= "Please enter your email";
	public String  lastNameMsgError="Last name is required."
			+ "";
	// register data
	
	public String firstName = "John";
	public String lastName = "Doe";
	public String firestnameEmpty = "";
	public String lastnameEmpty = "";
	public String companyName = "No 1 Company";
	public String urlregistredSuccsses = "https://demo.nopcommerce.com/registerresult/1?returnUrl=/";
	public String errorMsgConfirmPassword="The password and confirmation password do not match.";
	
	//wish list data
	
	public String wishlistTitle = "nopCommerce demo store. Wishlist";
	
	public String addToCartTitle = "nopCommerce demo store. Shopping cart";
	public String emailfriend = "https://demo.nopcommerce.com/emailwishlist";
	public String onlyRegisCanEmail = "Only registered customers can use email a friend feature";
	public String QuantityInWishlist = "3";
	public String subTotalExpectedSum = "$153.00";
	public String firstPrizePiesUrl = "https://demo.nopcommerce.com/first-prize-pies" ;

	//shopping cart data
	
	public String shoppingCartTitle = "Shopping cart";
	public String LevisJeans = "Levi's 511 Jeans";
	public String shoppingCartIsEmpty = "Your Shopping Cart is empty!";
	public String invalidCouponeCode = "55555";
	public String couponCodeCannotBeFound = "The coupon code cannot be found";
	public String validCouponeCode = "123";
	public String theCouponWasAdded = "The coupon code was applied";

	public String recurringItemsErrorMsg = "Your cart has standard and auto-ship (recurring) items. Only one product type is allowed per order.";

	//PDP test data
    public String nikeLooseSKUNumber = "NK_TLS_RS";
    public int indexNumber = 3;
	public String i = "10";
    
	// register page
	public String registertitle = "nopCommerce demo store. Register";
	
	//checkbox
	public String checkoutTitle = "nopCommerce demo store. Checkout";
	public String city = "Vien";
	public String address1 = "Ludwig van Beethoven 3" ;
	public String zip = "12345678";
	public String phoneNumber = "00789654865";
	public String cardNumber = "1111222233334444";
	public String cardCodeNumber = "456";
	
	public String confirmOrder = "https://demo.nopcommerce.com/onepagecheckout#opc-confirm_order";
	
	public String startingDateRent = "10-OCTOBER-2023";
	public String endDateRent = "15-OCTOBER-2023";
	
	//plp test data
	
	public String ram8GB = "8GB";
	public String i5CPU = "Core i5";
	public String nokiaLumia1020 = "Nokia Lumia 1020";
	public String htcOneMiniBlue = "HTC One Mini Blue";
	public String youHaveNoItemsToCompare = "You have no items to compare.";

	//pdp test data
	public String reviewPage = "https://demo.nopcommerce.com/productreviews/38";
	public String onlyRegCanWriteReviews="Only registered users can write reviews";
	public String reviewTitle = "I love this camera";
	public String reviewText = "This i one of my favorite...";
	public String productReviewSuccessAdded= "Product review is successfully added.";
	public String sampleDownloader="Example: This is a sample download";
	
	//account test data
	public String accountPageTitle="My account - Customer info";
	public String succssesfulBarNotification = "The customer info has been updated successfully.";
	public String theNewPassDifferentWithConfirmPass = "The new password and confirmation password do not match.";
	
}
