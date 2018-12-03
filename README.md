# AppleInventory

This is a JavaFX-MySQL Apple Inventory management software for those who wants to keep track of their apples.

## Description

This is a mid level entry inventory management software meant for small to medium size businesses. You can also process transactions inside this software. 
Some of the features are:
   * Log-In / Register functionality
   * Passwords stored in Database are **SHA-256** protected
   * Salted passwords stored inside database
   * Add to your stock
   * Update your stock
   * Delete your stock
   * Visual sales statistics
   * New transactions with total amount
   * Past transactions with timestamp
   * Search past transactions on the basis of Date / Amount
   * Manage accounts.

## Build With

* [Eclipse](https://www.eclipse.org/ide/) - The IDE we used
* [MySQL](https://www.mysql.com/) - Database we used
* [XAMPP](https://www.apachefriends.org/index.html) - Local Database we used

## Authors
* **Utsav Dave**
* **Jonathan Stevanka**
* **Jianqin Wang**

## To Make It Work
* Create a `Const_Credential` class file inside `Database` Package. Input the following code:

```java
public static final String DB_NAME = "yourDatabaseName";
public static final String DB_PASS = "yourDatabasePassword";
public static final String DB_USER = "yourUserNameDatabase";

```

* After creating this file. Run `TestDatabase` file under `default` package.
   * This would create all the necessary tables for the application.
   
* Than inside `role` table inside your database, insert 3 entries similar to picture shown below.
![RoleTable](https://github.com/utsavDave97/AppleInventory/blob/master/ScreenShots/RoleTable.png)

## Screen shots & its explanation

* Database Design
![Database](https://github.com/utsavDave97/AppleInventory/blob/master/ScreenShots/DatabaseDesign.png)
 
* When the application launches the Log-In Screen appears. Here the existing user can log in with proper credentials. For new user, Register option is to clicked.
![Log_In](https://github.com/utsavDave97/AppleInventory/blob/master/ScreenShots/LogIn.png)

* This is the Register Screen, here new user can be created. Here user enters First Name, Last Name, Email ID, and Password.
![Register](https://github.com/utsavDave97/AppleInventory/blob/master/ScreenShots/Register.png)

* When the User logs-in, Home Screen appears.The sole purpose of Home Screen is to give a table view of inventory. There is navigation bar to switch to different screens. Log Out button is to log out of the system.
![Home](https://github.com/utsavDave97/AppleInventory/blob/master/ScreenShots/HomeScreen.png)

* Now, suppose user wants to add to inventory. There is Add Stock option inside Navigation Bar. Here the user can Add new stock to inventory.
  * Here, user needs to add Apple Name, Quantity, Taste of Apple & Price/Kilo.
![AddStock](https://github.com/utsavDave97/AppleInventory/blob/master/ScreenShots/AddStock.png)

* Also, user has the option of updating the existing stock. User can update on the basis of Apple Name, Quantity, Price & Taste.
![UpdateStock](https://github.com/utsavDave97/AppleInventory/blob/master/ScreenShots/UpdateStock.png)

* Also, user has the option of deleting the existing stock. The idea is to set the quantity to 0.
![DeleteStock](https://github.com/utsavDave97/AppleInventory/blob/master/ScreenShots/DeleteStock.png)

* Now the idea behind New Transaction Screen is to process sale. Here the user can add number of quantity of certain Apple. It will calculate tax and total price.
![NewTransaction](https://github.com/utsavDave97/AppleInventory/blob/master/ScreenShots/NewTransaction.png)

* This is the Completed Transaction Screen. This screen shows history of sale by a particular user. You can refine your search according to Amount and Date.
![CompletedTransaction](https://github.com/utsavDave97/AppleInventory/blob/master/ScreenShots/CompletedTransaction.png)

* This is the Statistics Screen. This screen shows a pie-chart of sale done to date.
![StatisticsScreen](https://github.com/utsavDave97/AppleInventory/blob/master/ScreenShots/StatisticsScreen.png)

* This is the Account Management Screen. This screen is only accessible to Administrator. The accounts of clerk and manager can be updated/deleted here.
![AccountManagement](https://github.com/utsavDave97/AppleInventory/blob/DAObranch/ScreenShots/AccountManagement.png)

## Credits

* [Apple Icon](https://www.flaticon.com/authors/smashicons)
* [User Icon](https://www.flaticon.com/authors/freepik)
* [Key Icon](https://www.flaticon.com/authors/yannick)
* [Navigation Icon](https://www.flaticon.com/authors/smashicons)
* [Log Out Icon](https://www.flaticon.com/authors/freepik)
