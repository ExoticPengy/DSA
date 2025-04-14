/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

/**
 *
 * @author mings
 */
public class MessageUI {
    public static void displayInvalidChoiceMessage(){
        System.out.println("Invalid choice. Please enter a valid number.");
    }
    
    public static void displayInvalidCharacterMessage(){
        System.out.println("Invalid input. Please enter a number.");
    }
    
    public static void displayExitMessage(){
        System.out.println("Exiting the system...");
    }
    
    public static void pressEnterContinue(){
        System.out.print("Press enter to continue...");
    }
    
    public static void pressAnyKeyContinue() {
        System.out.print("Press any key to continue...");
    }
}
