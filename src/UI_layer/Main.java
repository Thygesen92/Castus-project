package UI_layer;


import DB_layer.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javax.xml.soap.Text;

/**
 * Created by thyge on 15-05-2017.
 */
public class Main extends Application
{
    UserDB userDB = new UserDB();

    Label lFull_Name = new Label("Your full name?");
    Label lGot_Kids = new Label("Do you have kids?");
    Label lHow_Many_Kids = new Label("How many kids do you have?");
    Label lTlf = new Label("Your phone number?");
    Label lEmail = new Label("Your email?");
    Label lAddress = new Label("Your address");
    Label lFavorite_Product = new Label("What is your favorite produkt?");

    //Combobox
    ComboBox<String> cGot_kids;
    ComboBox<Integer> cNumber_of_kids;
    ComboBox<String> cFavorite_product;

    //Button
    Button b_SignUp = new Button("Sign up");

    //Textfield
    TextField tFull_name = new TextField();
    TextField tTlf = new TextField();
    TextField tEmail = new TextField();
    TextField tAdresse = new TextField();

    //ComboBox

    private void signUpButtonHitted()
    {
        String name;
        String gotKids;
        int numberOfKids;
        int phoneNumber;
        String email;
        String address;
        String favoriteProduct;

        name = tFull_name.getText();
        gotKids = cGot_kids.getValue();
        numberOfKids = cNumber_of_kids.getValue();
        phoneNumber = Integer.parseInt(tTlf.getText());
        email = tEmail.getText();
        address = tAdresse.getText();
        favoriteProduct = cFavorite_product.getValue();

        userDB.insertIntoDB(name,gotKids,numberOfKids,phoneNumber,email,address,favoriteProduct);
    }


    public static void main(String[] args)
    {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception
    {
        //Layout
        VBox vBox = new VBox(10);

        BackgroundImage myBI= new BackgroundImage(new Image("http://i.imgur.com/FwuQ7XA.png"),
        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        vBox.setBackground(new Background(myBI));

        buildName();
        buildPhone();
        buildEmail();
        buildAddress();
        buildGotKids();
        buildHowManyKids();
        buildFavoriteProduct();
        buildButton();

       vBox.getChildren().addAll(lFull_Name, tFull_name,cGot_kids,cNumber_of_kids,lTlf,tTlf,
               lEmail, tEmail, lAddress, tAdresse,cFavorite_product,b_SignUp);


        Scene scene = new Scene(vBox, 670 , 570);


        primaryStage.setResizable(true);
        primaryStage.setTitle("Konkurrence");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public void buildName()
    {
        lFull_Name.setTranslateY(50);
        lFull_Name.setTranslateX(280);

        tFull_name.setTranslateX(210);
        tFull_name.setTranslateY(45);
        tFull_name.setMaxWidth(230);
    }


    public void buildPhone()
    {
        lTlf.setTranslateX(265);
        lTlf.setTranslateY(55);
        tTlf.setTranslateX(210);
        tTlf.setTranslateY(50);
        tTlf.setMaxWidth(230);
    }


    public void buildEmail()
    {
        lEmail.setTranslateX(295);
        lEmail.setTranslateY(50);
        tEmail.setTranslateX(210);
        tEmail.setTranslateY(45);
        tEmail.setMaxWidth(230);
    }


    public void buildAddress()
    {
        lAddress.setTranslateX(290);
        lAddress.setTranslateY(40);
        tAdresse.setTranslateX(210);
        tAdresse.setTranslateY(35);
        tAdresse.setMaxWidth(230);
    }


    public void buildGotKids()
    {
        cGot_kids = new ComboBox<>();
        cGot_kids.setPromptText("Do you have kids");
        cGot_kids.getItems().addAll(
                "Yes","No"
        );
        cGot_kids.setTranslateX(260);
        cGot_kids.setTranslateY(50);
    }


    public void buildHowManyKids()
    {
        cNumber_of_kids = new ComboBox<>();
        cNumber_of_kids.setPromptText("Number of kids?");
        cNumber_of_kids.getItems().addAll(
                1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16
        );
        cNumber_of_kids.setTranslateX(260);
        cNumber_of_kids.setTranslateY(55);
    }


    public void buildFavoriteProduct()
    {
        cFavorite_product = new ComboBox<>();
        cFavorite_product.setPromptText("Favorite Product");
        cFavorite_product.getItems().addAll(
                "Frugtstænger","Grinebidder","Boost me Up","Frugtpålæg","Frugtruller"
        );
        cFavorite_product.setTranslateX(260);
        cFavorite_product.setTranslateY(30);
    }


    public void buildButton()
    {
        b_SignUp.setTranslateX(275);
        b_SignUp.setTranslateY(30);
        b_SignUp.setMaxWidth(100);

        b_SignUp.setOnAction(event -> signUpButtonHitted());
    }
}
