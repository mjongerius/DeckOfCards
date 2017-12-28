# DeckOfCards
This project was created as part of a code challenge when applying for a contract opportunity with Robots and Pencils

### The Code Challenge
The email I received had a PDF attachment with the code challenge details.  The one side talked about a Server Code Challenge.  While the instructions outlined to write a simple class in the language of my choice to represent a deck of cards.  Presentation is important but I did not want to spend a lot of time with setting up server code interacting with a client. 

The assignment gave some flexibility as well, provided I explained my choices.  So I decided to go with a simple Java program which can be run inside the IDE - with interactions via the console.  The main goal seemed to be to showcase the deck of cards features.  Presentation is still important so I did decided on a compromise by using Unicode for symbols for the card suits; because A-♥ is lot easier for the brain to grasp compared to "Ace of Hearts", especially when multiple cards are being displayed.

### Other considerations
For my JUnits I focused on ensuring that the various classes worked as designed and that exceptions were thrown when required.  This deck of cards consists of the 4 well known suits, and 13 cards per suit - no Jokers.

The deck allows for dealing from the top or the bottom.  The deck also knows about its own state, meaning whether deck has been shuffled or not and how many cards are (left) in the deck.

My focus for this code challenge was on being thorough when it comes to the requirements rather than being flashy with a lot of graphics.  Although as mentioned before, using the 4 card symbols via Unicode was important to me as it truly facilitates absorbing all the card details.

### What I used for development
I used Eclipse Java Oxygen as my IDE (Version: Oxygen.2 Release 4.7.2, Build id: 20171218-0600).  I changed my Preferences -> Workspace -> Text File Encoding setting to save files in UTF-8 in order to be able to display the four card suits symbols properly: ♥ ♠ ♦ ♣ 

I also included JUnits and for that I used 2 jar files which can be found in the lib folder.



**Martin Jongerius, P.Eng.**