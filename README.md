# Inventory-System

Created an inventory management system with JavaFX that has a graphical user interface and the following GUI forms:
1.  Main form
2.  Add Part form
3.  Modify Part form
4.  Add Product form
5.  Modify Product form


Note: data for this application is nonpersistent and will reside in computer memory while in use.

--------


## Functionalities of the Main form:
- The Parts pane
  - The Add button opens the Add Part form.
  - The Modify button opens Modify Part form.
  - The Delete button deletes the selected part or displays a descriptive error message in a dialog box.
  - When the user searches for parts by ID or name (partial or full name) using the text field, the application displays matching results in the 
    Parts TableView. If the part is not found, the application displays an error message in a dialog box.

- The Products pane
  - The Add button opens the Add Product form.
  - The Modify button opens the Modify Product form.
  - The Delete button deletes the selected product or displays a descriptive error message in a dialog box.
  - When the user searches for products by ID or name (partial or full name) using the text field, the application displays matching results 
    in the Products TableView. If the product is not found, the application displays an error message in a dialog box.
    
 
 ## Functionalities of the Part form: 
- Add Part form 
  - The In-House and Outsourced radio buttons switch the bottom label to the correct value (Machine ID or Company Name).
  - The application auto-generates a unique part ID and text field is disabled.
  - The user can enter a part name, inventory level or stock, a price, maximum and minimum values, and company name or machine ID values into active text fields.
  - After saving the data, users are automatically redirected to the Main form.
  - Canceling or exiting this form redirects users to the Main form.

- Modify Part form
  - The text fields populate with the data from the chosen part.
  - The In-House and Outsourced radio buttons switch the bottom label to the correct value (Machine ID or Company Name) and swap In-House parts and Outsourced parts.
  - The user can modify data values in the text fields sent from the Main form except the part ID.
  - After saving modifications to the part, the user is automatically redirected to the Main form.
  - Canceling or exiting this form redirects users to the Main form.



 ## Functionalities of the Product form: 
- The Add Product form
  - The application auto-generates a unique product ID.
  - The product ID text field must be disabled and cannot be edited or changed.
  - The user can enter a product name, inventory level or stock, a price, and maximum and minimum values. 
  - The user can search for parts (top table) by ID or name (partial or full name). If the part or parts are found, the application highlights a single part or filters multiple       parts. If the part or parts are not found, the application displays an error message in a dialog box.
  - If the search field is set to empty, the table should be repopulated with all available parts.
  - The top table should be identical to the Parts TableView in the Main form.
  - The user can select a part from the top table. The user then clicks the Add button, and the part is copied to the bottom table. (This associates one or more parts with a           product.)
  - The Remove Associated Part button removes a selected part from the bottom table. (This dissociates or removes a part from a product.)
  - After saving the data, the user is automatically redirected to the Main form.
  - Canceling or exiting this form redirects users to the Main form.

- The Modify Product form
  - The text fields populate with the data from the chosen product, and the bottom TableView populates with the associated parts.
  - The user can search for parts (top table) by ID or name (partial or full name). If the part or parts are found, the application highlights a single part or filters multiple       parts. If the part is not found, the application displays an error message in a dialog box.
  - If the search text field is set to empty, the table should be repopulated with all available parts.The top table should be identical to the Parts TableView in the Main form.
  - The user may modify or change data values.
  - The product ID text field must be disabled and cannot be edited or changed.
  - The user can select a part from the top table. The user then clicks the Add button, and the part is copied to the bottom table. (This associates one or more parts with a           product.)
  - The user may associate zero, one, or more parts with a product.
  - The user may remove or disassociate a part from a product.
  - After saving modifications to the product, the user is automatically redirected to the Main form.
  - Canceling or exiting this form redirects users to the Main form.


---------

### Input validation and logical error checks using a dialog box 
- Min should be less than Max, and Inventory should be between those two values.
- The user should not delete a product that has a part associated with it.
- The application confirms the “Delete” and “Remove” actions.
- The application will not crash when inappropriate user data is entered in the forms.




