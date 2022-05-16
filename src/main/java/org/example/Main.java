package org.example;

//import java.sql.SQLOutput;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {



        //number of walls to loop through system
        System.out.println("WELCOME TO WALL PAINT CALCULATOR 3000");
        int numberOfWalls = 1;
        System.out.println("You have " + numberOfWalls + " wall.");

        //wall width
        //wall height
        //product for area
        float wallWidth = 10;
        System.out.println("How wide, in metres, is your wall?");
        Scanner widthScanner = new Scanner(System.in);
        wallWidth = widthScanner.nextFloat();

        float wallHeight = 3;
        System.out.println("How tall, in metres, is your wall?");
        Scanner heightScanner = new Scanner(System.in);
        wallHeight = heightScanner.nextFloat();

        float wallAreaPrimitive = wallWidth * wallHeight;
        System.out.println("Your wall's primitive area is " + wallAreaPrimitive + " square metres.");


        //number of plug sockets
        int numberOfSockets = 6;
        //types of plug socket / light switch etc.
        int numberOfSwitches = 2;
        System.out.println("How many light switches do you have on this wall?");
        Scanner countScanner = new Scanner(System.in);
        numberOfSwitches = countScanner.nextInt();

        int numberOfSingles = 2;
        System.out.println("How many single-wide plug sockets do you have on this wall?");
        //Scanner countScanner = new Scanner(System.in);
        numberOfSingles = countScanner.nextInt();

        int numberOfDoubles = 2;
        System.out.println("How many double-wide plug sockets do you have on this wall?");
        //Scanner countScanner = new Scanner(System.in);
        numberOfDoubles = countScanner.nextInt();

        numberOfSockets = numberOfSingles + numberOfDoubles + numberOfSwitches;
        float sockWidthSingle = 0.1f;
        float sockWidthDouble = 0.2f;
        float sockHeight = 0.1f;
        //area of a plug socket (single, double, lightswitch)
        float sockAreaSingle = sockWidthSingle * sockHeight;
        float sockAreaDouble = sockWidthDouble * sockHeight;
        float sockAreaSum = ((numberOfSingles + numberOfSwitches) * sockAreaSingle) + (numberOfDoubles * sockAreaDouble);
        System.out.println("You have " + numberOfSockets + " sockets and switches on your wall");
        System.out.println("The total area of your switches and sockets is " + sockAreaSum);


        int numberOfWindows = 1;//number of windows to loop through

        System.out.println("How many windows do you have?");

        Scanner inWindows = new Scanner(System.in);
        numberOfWindows = inWindows.nextInt();

        float wind1Width = 0f;//width of window (can also do doors)
        float wind1Height = 0f;

        switch (numberOfWindows){
            case 0:

                break;
            default:

                System.out.println("You have " + numberOfWindows + " window(s) on your wall.");

                //height of window
                System.out.println("How wide, in metres, is your window?");
                wind1Width = widthScanner.nextFloat();

                System.out.println("How tall, in metres, is your window?");
                wind1Height = heightScanner.nextFloat();

                //float wind2Width = 1.5f;
                //float wind2Height = 3f;



                break;
        }

        float wind1Area = wind1Width * wind1Height;//product for area of window
        //float wind2Area = wind2Width * wind2Height;
        float windAreaSum = wind1Area; // + wind2Area;

        System.out.println("The sum of your window area is " + windAreaSum + " square metres.");

        //subtract product of sockets and area of sockets from wall area
        //subtract from wall area
        float adjustedWallArea = wallAreaPrimitive - (sockAreaSum + windAreaSum);

        System.out.println("The total complex surface area of your wall is " + adjustedWallArea +".");

        //paint litres per square meter - approx 1 litre per 6.5 mArea
        float mAreaPerLitre = 6;
        System.out.println("Assuming you can paint "+ mAreaPerLitre + " square metres of wall per litre of paint...");
        float totalPaint = adjustedWallArea / mAreaPerLitre;
        System.out.println("You should expect to need " + totalPaint + " litres of paint.");

        float[] litresPerPot = {10, 5, 2, 1, 0.5f};
        int[] numberOfPots = {0, 0, 0, 0, 0};
        float[] paintPrice = {10.99f, 5.99f, 2.99f, 1.99f, 1.19f};

        float litresRemainder = totalPaint;

        //for ( int pots : numberOfPots
        //     ) {
        //
        //}

        int index = 0;

        while (index < litresPerPot.length){

            if (litresRemainder >= litresPerPot[index]){
                numberOfPots[index] = Math.round(litresRemainder / litresPerPot[index]);
                litresRemainder -= (numberOfPots[index] * litresPerPot[index]);
            }

            index ++;
        }

        //if (litresRemainder >= litresPerPot[0]){
        //    numberOfPots[0] = Math.round(litresRemainder / litresPerPot[0]);
        //    litresRemainder -= (numberOfPots[0] * litresPerPot[0]);
        //}

        //if (litresRemainder >= litresPerPot[1]){
        //    numberOfPots[1] = Math.round(litresRemainder / litresPerPot[1]);
        //    litresRemainder -= (numberOfPots[1] * litresPerPot[1]);
        //}

        //if (litresRemainder >= litresPerPot[2]){
        //    numberOfPots[2] = Math.round(litresRemainder / litresPerPot[2]);
        //    litresRemainder -= (numberOfPots[2] * litresPerPot[2]);
        //}

        //if (litresRemainder >= litresPerPot[3]){
        //    numberOfPots[3] = Math.round(litresRemainder / litresPerPot[3]);
        //    litresRemainder -= (numberOfPots[3] * litresPerPot[3]);
        //}

        //if (litresRemainder >= litresPerPot[4]){
        //    numberOfPots[3] = Math.round(litresRemainder / litresPerPot[4]);
        //    litresRemainder -= (numberOfPots[4] * litresPerPot[4]);
        //} else
        //
        if (litresRemainder > 0){
            numberOfPots[numberOfPots.length-1] += 1;
        }

        // dot equals .=
        //if else chain for calculating pot sizes needed

        //int totalPots = Math.round(totalPaint / litresPerPot[0]) + 1;


        System.out.println("This will require:" );

        index = 0;

        //while (index < litresPerPot.length){
        if(numberOfPots[0] > 0) {
            System.out.println(numberOfPots[0] + " times " + litresPerPot[0] + "-litre pots of paint.");
        }

        if(numberOfPots[1] > 0) {
            System.out.println(numberOfPots[1] + " times " + litresPerPot[1] + "-litre pots of paint.");
        }

        if(numberOfPots[2] > 0) {
            System.out.println(numberOfPots[2] + " times " + litresPerPot[2] + "-litre pots of paint.");
        }

        if(numberOfPots[3] > 0) {
            System.out.println(numberOfPots[3] + " times " + litresPerPot[3] + "-litre pots of paint.");
        }

        if(numberOfPots[4] > 0) {
            System.out.println(numberOfPots[4] + " times " + litresPerPot[4] + "-litre pots of paint.");
        }
        //product of area and paint per area for volume of paint needed
        //select next size up from volume needed  - what are available sizes?

        //store remainder - volume needed mod volume of largest pot
        //volume needed divided by largest pot gets number of pots needed
        //loop though remainder as volume needed
        //number of pots times price gets total price

        //designated colour in (not RGB i guess) CMY
        byte cyan = (byte) 200;
        byte magenta = (byte) 200;
        byte yellow = (byte) 200;
        //calculate mix colours
        // calc volume of each paint

        //length of frogging tape?


        //bonus; stairs
        // height of wall at top * length of wall at top
        //plus
        //(height of wall at bottom - height of wall at top) * length of wall at top/2

        //variable = (condition) ? expressionTrue : expressionFalse;
        //int x = 5;
        //int y = 3;
        //String greater = (x > y) ? "Greater" : "";
    }

    {
        //
        Random rand = new Random();
        int num1 = rand.nextInt(50);
        int num2 = rand.nextInt(50);
        int num3 = rand.nextInt(50);

        int sum = num1 + num2 + num3;
        int prod = num1 * num2 * num3;

        System.out.println("A crafty sphinx blocks your way, " +
                "\nand she wont let you pass until " +
                "\nyou guess her three favourite numbers.");


        System.out.println("\nShe gives you two hints: " +
                "\nThe sum of her favourite numbers is " + sum +
                "\nThe product of her favourite numbers is " + prod +
                "\n" +
                "\nWhat are her favourite numbers?");


        Scanner scanner = new Scanner(System.in);
        System.out.println("First number:");
        int a = scanner.nextByte();
        System.out.println("Second number:");
        int b = scanner.nextByte();
        System.out.println("Third number:");
        int c = scanner.nextByte();

        System.out.println("You guessed: "+ a + " , " + b +" , " + c);

        if (a*b*c == prod && a+b+c == sum){
            System.out.println("Congrats!  Good guess!");
            System.out.println("The sphinx lets you pass!");
        } else {
            System.out.println("Wrong numbers!");
            System.out.println("The sphinx will now eat you for her dinner!");
        }

    }

    {
        String myName = "DEFAULT";

        byte myAge = 30;
        Scanner scanner = new Scanner(System.in);



        System.out.println("Hello stranger, what's your name?"); // " + myString + "!");

        myName = scanner.nextLine();

        System.out.println("Hello " + myName + "!");
        System.out.println("How old are you?"); // " + myString + "!");
        myAge = scanner.nextByte();

        System.out.println("Wow, " + myAge + "?");

        Date d = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        int currentYear = cal.get(Calendar.YEAR);
        int birthYear = currentYear - myAge;

        System.out.println(birthYear + " was a good year!");

        System.out.println("\nWhat are your hobbies?");
        System.out.println("Tell me the name of one of your hobbies:");
        String hobby1 = "DEFAULT";
        hobby1 = scanner.nextLine();
        hobby1 = scanner.nextLine();
        System.out.println("Then, tell me another hobby of yours:");
        String hobby2 = scanner.nextLine();
        System.out.println("Last, tell me about one more:");
        String hobby3 = scanner.nextLine();

        System.out.println("Okay.. And tell me something you're looking forward to.");
        String hope1 = scanner.nextLine();

        System.out.println("... \n"+ hobby1 + "\n... \n" + hobby2 + "\n... \n" + hobby3 + "\n... \n" + hope1 + "\n... \nHAH! Nerd.");

        System.out.println("Please rate my script out of 10.\n10 = God Tier, 0 = Skynet but Worse");
        //myName = scanner.nextLine();
        int myScore = scanner.nextByte();

        if (myScore <= 4){
            System.out.println("Ouch... Murdered by numbers...");
        } else if (myScore >= 7){
            System.out.println("Yeah, that's right, I'm awesome!");
        } else {
            System.out.println("Average!?  Jeez, you have no taste for quality.");
        }

        System.out.println("Aight, Main.audi!");
    }
}