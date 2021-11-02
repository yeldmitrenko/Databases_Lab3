package com.dmitrenko.view;

import com.dmitrenko.controller.implementation.*;
import com.dmitrenko.model.entity.*;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MyView {

    private final Map<String, Printable> menu = new LinkedHashMap<>();
    private static final Scanner SCANNER = new Scanner(System.in);

    private final PaymentController paymentController = new PaymentController();
    private final SecurityController securityController = new SecurityController();
    private final GameController gameController = new GameController();
    private final GameChatController gameChatController = new GameChatController();
    private final MessageController messageController = new MessageController();
    private final AudioController audioController = new AudioController();
    private final MediaController mediaController = new MediaController();
    private final UserController userController = new UserController();

    public MyView() {
        menu.put("11", this::getAllPayments);
        menu.put("12", this::getPaymentById);
        menu.put("13", this::createPayment);
        menu.put("14", this::updatePayment);
        menu.put("15", this::deletePayment);

        menu.put("21", this::getAllSecurityInfo);
        menu.put("22", this::getSecurityByLogin);
        menu.put("23", this::createSecurity);
        menu.put("24", this::updateSecurity);
        menu.put("25", this::deleteSecurity);

        menu.put("31", this::getAllGames);
        menu.put("32", this::getGameById);
        menu.put("33", this::createGame);
        menu.put("34", this::updateGame);
        menu.put("35", this::deleteGame);

        menu.put("41", this::getALlGameChats);
        menu.put("42", this::getGameChatByID);
        menu.put("43", this::createGameChat);
        menu.put("44", this::updateGameChat);
        menu.put("45", this::deleteGameChat);

        menu.put("51", this::getAllMessages);
        menu.put("52", this::getMessageById);
        menu.put("53", this::createMessage);
        menu.put("54", this::updateMessage);
        menu.put("55", this::deleteMessage);

        menu.put("61", this::getAllAudio);
        menu.put("62", this::getAudioById);
        menu.put("63", this::createAudio);
        menu.put("64", this::updateAudio);
        menu.put("65", this::deleteAudio);

        menu.put("71", this::getAllMedia);
        menu.put("72", this::getMediaById);
        menu.put("73", this::createMedia);
        menu.put("74", this::updateMedia);
        menu.put("75", this::deleteMedia);

        menu.put("81", this::getAllUsers);
        menu.put("82", this::getUserById);
        menu.put("83", this::createUser);
        menu.put("84", this::updateUser);
        menu.put("85", this::deleteUser);
    }


    //#########################################################################

    private void outputMenu() {
        System.out.println("\nMENU:");
        for (Printable str : menu.values()) {
            System.out.println(str);
        }
    }

    public final void show() {
        String input;
        Menu showMenu = new Menu();
        showMenu.displayMenu();
        System.out.println("\nEnter numbers:\n");
        do {
            try {
                input = SCANNER.next();
                menu.get(input).print();
            } catch (Exception ignored) {
            }
        } while (SCANNER.hasNext());
    }

    //#########################################################################

    private void getAllPayments() throws SQLException {
        System.out.println(paymentController.findAll() + "\n");
    }

    private void getPaymentById() throws SQLException {
        System.out.println("Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(paymentController.findById(id) + "\n");
    }

    private Payment getPaymentInputs() {
        System.out.println("\nEnter card number: ");
        Long cardNumber = SCANNER.nextLong();
        System.out.println("Enter expiration date: ");
        Integer expirationDate = SCANNER.nextInt();
        System.out.println("Enter cvc: ");
        Integer cvc = SCANNER.nextInt();
        System.out.println("Enter your name: ");
        String name = SCANNER.next();
        return new Payment(cardNumber, expirationDate, cvc, name);
    }

    private void createPayment() throws SQLException {
        Payment payment = getPaymentInputs();
        paymentController.create(payment);
        System.out.println("Payment was successfully created!\n");
    }

    private void updatePayment() throws SQLException {
        System.out.println("\nEnter ID to update: ");
        Integer id = SCANNER.nextInt();
        Payment payment = getPaymentInputs();
        payment.setId(id);
        paymentController.update(payment.getId(), payment);
        System.out.println("Payment with ID = " + id + "was updated\n");
    }

    private void deletePayment() throws SQLException {
        System.out.println("\nEnter ID to delete the payment: ");
        Integer id = SCANNER.nextInt();
        paymentController.delete(id);
        System.out.println("Payment with ID = " + id + "was deleted\n");
    }

    //########################################################################

    private void getAllSecurityInfo() throws SQLException {
        System.out.println("\n" + securityController.findAll() + "\n");
    }

    private void getSecurityByLogin() throws SQLException {
        System.out.println("\nEnter login: ");
        String login = SCANNER.next();
        System.out.println(securityController.findByLogin(login) + "\n");
    }

    private Security getSecurityInputs() {
        System.out.println("\nEnter login: ");
        String login = SCANNER.next();
        System.out.println("Enter password: ");
        String password = SCANNER.next();
        return new Security(login, password);
    }

    private void createSecurity() throws SQLException {
        System.out.println("\n");
        Security security = getSecurityInputs();
        securityController.create(security);
        System.out.println("Security was successfully created!\n");
    }

    private void updateSecurity() throws SQLException {
        System.out.println("\nEnter login to update: ");
        String login = SCANNER.next();
        Security security = getSecurityInputs();
        security.setLogin(login);
        securityController.update(security.getLogin(), security);
        System.out.println("Security with login: " + login + "was updated\n");
    }

    private void deleteSecurity() throws SQLException {
        System.out.println("\nEnter login to delete account: ");
        String login = SCANNER.next();
        securityController.delete(login);
        System.out.println("Account with login: " + login + "was deleted\n");
    }

    //##################################################################################

    private void getAllGames() throws SQLException {
        System.out.println("\n" + gameController.findAll() + "\n");
    }

    private void getGameById() throws SQLException {
        System.out.println("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(gameController.findById(id) + "\n");
    }

    private Game getGameInputs() {
        System.out.println("\nEnter a name: ");
        String name = SCANNER.next();
        System.out.println("Enter a price for the game: ");
        Integer price = SCANNER.nextInt();
        System.out.println("Enter a category of a game: ");
        String category = SCANNER.next();
        return new Game(name, price, category);
    }

    private void createGame() throws SQLException {
        System.out.println("\n");
        Game game = getGameInputs();
        gameController.create(game);
        System.out.println("Game was successfully created!\n");
    }

    private void updateGame() throws SQLException {
        System.out.println("\nEnter ID of the game to update: ");
        Integer id = SCANNER.nextInt();
        Game game = getGameInputs();
        game.setId(id);
        gameController.update(game.getId(), game);
        System.out.println("Game with ID = " + id + "was updated\n");
    }

    private void deleteGame() throws SQLException {
        System.out.println("\nEnter game ID to delete: ");
        Integer id = SCANNER.nextInt();
        gameController.delete(id);
        System.out.println("Game with ID = " + id + "was deleted\n");
    }

    //#############################################################################

    private void getALlGameChats() throws SQLException {
        System.out.println("\n" + gameChatController.findAll() + "\n");
    }

    private void getGameChatByID() throws SQLException {
        System.out.println("\nEnter ID of game chat: ");
        Integer id = SCANNER.nextInt();
        System.out.println(gameChatController.findById(id) + "\n");
    }

    private GameChat getGameChatInputs() {
        System.out.println("\nEnter name of a chat: ");
        String name = SCANNER.next();
        System.out.println("Enter ID of a game: ");
        Integer gameId = SCANNER.nextInt();
        return new GameChat(name, gameId);
    }

    private void createGameChat() throws SQLException {
        System.out.println("\n");
        GameChat gameChat = getGameChatInputs();
        gameChatController.create(gameChat);
        System.out.println("Game chat was successfully created!\n");
    }

    private void updateGameChat() throws SQLException {
        System.out.println("\nEnter ID of a game chat to update: ");
        Integer id = SCANNER.nextInt();
        System.out.println("Enter game ID for updating chat: ");
        Integer gameId = SCANNER.nextInt();
        GameChat gameChat = getGameChatInputs();
        gameChat.setId(id);
        gameChat.setGameId(gameId);
        gameChatController.update(gameChat.getId(), gameChat);
        System.out.println("Game chat with ID = " + id + "was updated\n");
    }

    private void deleteGameChat() throws SQLException {
        System.out.println("\nEnter ID to delete a game chat: ");
        Integer id = SCANNER.nextInt();
        gameChatController.delete(id);
        System.out.println("Game chat with ID = " + id + "was deleted\n");
    }

    //#######################################################################################

    private void getAllMessages() throws SQLException {
        System.out.println("\n" + messageController.findAll() + "\n");
    }

    private void getMessageById() throws SQLException {
        System.out.println("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(messageController.findById(id) + "\n");
    }

    private Message getMessageInputs() {
        System.out.println("\nEnter a date: ");
        Integer date = SCANNER.nextInt();
        System.out.println("Enter a message: ");
        String message = SCANNER.next();
        System.out.println("Enter ID of a game chat: ");
        Integer gameChatId = SCANNER.nextInt();
        return new Message(date, message, gameChatId);
    }

    private void createMessage() throws SQLException {
        System.out.println("\n");
        Message message = getMessageInputs();
        messageController.create(message);
        System.out.println("Message was successfully created!\n");
    }

    private void updateMessage() throws SQLException {
        System.out.println("\nEnter ID to update: ");
        Integer id = SCANNER.nextInt();
        System.out.println("Enter ID of game chat to update: ");
        Integer gameChatId = SCANNER.nextInt();
        Message message = getMessageInputs();
        message.setId(id);
        message.setGameChatId(gameChatId);
        messageController.update(message.getId(), message);
        System.out.println("Message with ID = " + id + "was updated\n");
    }

    private void deleteMessage() throws SQLException {
        System.out.println("\nEnter ID to delete message: ");
        Integer id = SCANNER.nextInt();
        messageController.delete(id);
        System.out.println("Message with ID = " + id + "was deleted\n");
    }

    //################################################################################

    private void getAllAudio() throws SQLException {
        System.out.println("\n" + audioController.findAll() + "\n");
    }

    private void getAudioById() throws SQLException {
        System.out.println("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(audioController.findById(id) + "\n");
    }

    private Audio getAudioInputs() {
        System.out.println("\nEnter duration: ");
        Integer duration = SCANNER.nextInt();
        System.out.println("Enter ID of a game chat: ");
        Integer gameChatId = SCANNER.nextInt();
        return new Audio(duration, gameChatId);
    }

    private void createAudio() throws SQLException {
        System.out.println("\n");
        Audio audio = getAudioInputs();
        audioController.create(audio);
        System.out.println("Audio was successfully created!\n");
    }

    private void updateAudio() throws SQLException {
        System.out.println("\nEnter ID to update: ");
        Integer id = SCANNER.nextInt();
        System.out.println("Enter ID of game chat to update: ");
        Integer gameChatId = SCANNER.nextInt();
        Audio audio = getAudioInputs();
        audio.setId(id);
        audio.setGameChatId(gameChatId);
        audioController.update(audio.getId(), audio);
        System.out.println("Audio with ID = " + id + "was updated\n");
    }

    private void deleteAudio() throws SQLException {
        System.out.println("\nEnter ID to delete audio: ");
        Integer id = SCANNER.nextInt();
        audioController.delete(id);
        System.out.println("Audio with ID = " + id + "was deleted\n");
    }

    //####################################################################################

    private void getAllMedia() throws SQLException {
        System.out.println("\n" + mediaController.findAll() + "\n");
    }

    private void getMediaById() throws SQLException {
        System.out.println("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(mediaController.findById(id) + "\n");
    }

    private Media getMediaInputs() {
        System.out.println("\nEnter name: ");
        String name = SCANNER.next();
        System.out.println("Enter size: ");
        Double size = SCANNER.nextDouble();
        System.out.println("Enter date: ");
        Integer date = SCANNER.nextInt();
        System.out.println("Enter ID of a game chat: ");
        Integer gameChatId = SCANNER.nextInt();
        return new Media(name, size, date, gameChatId);
    }

    private void createMedia() throws SQLException {
        System.out.println("\n");
        Media media = getMediaInputs();
        mediaController.create(media);
        System.out.println("Media was successfully created!\n");
    }

    private void updateMedia() throws SQLException {
        System.out.println("\nEnter ID to update: ");
        Integer id = SCANNER.nextInt();
        System.out.println("Enter ID of game chat to update: ");
        Integer gameChatId = SCANNER.nextInt();
        Media media = getMediaInputs();
        media.setId(id);
        media.setGameChatId(gameChatId);
        mediaController.update(media.getId(), media);
        System.out.println("Media with ID = " + id + "was updated\n");
    }

    private void deleteMedia() throws SQLException {
        System.out.println("\nEnter ID to delete media: ");
        Integer id = SCANNER.nextInt();
        mediaController.delete(id);
        System.out.println("Media with ID = " + id + "was deleted\n");
    }

    //##############################################################################

    private void getAllUsers() throws SQLException {
        System.out.println("\n" + userController.findAll() + "\n");
    }

    private void getUserById() throws SQLException {
        System.out.println("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(userController.findById(id) + "\n");
    }

    private User getUserInputs() {
        System.out.println("\nEnter name: ");
        String name = SCANNER.next();
        System.out.println("Enter surname: ");
        String surname = SCANNER.next();
        System.out.println("Enter username: ");
        String username = SCANNER.next();
        System.out.println("Enter phone number: ");
        String phoneNumber = SCANNER.next();
        System.out.println("Enter inform: ");
        String inform = SCANNER.next();
        System.out.println("Enter ID of a game chat: ");
        Integer gameChatId = SCANNER.nextInt();
        System.out.println("Enter payment ID: ");
        Integer paymentID = SCANNER.nextInt();
        System.out.println("Enter security login: ");
        String securityLogin = SCANNER.next();
        return new User(name, surname, username, phoneNumber, inform, gameChatId, paymentID, securityLogin);
    }

    private void createUser() throws SQLException {
        System.out.println("\n");
        User user = getUserInputs();
        userController.create(user);
        System.out.println("User was successfully created!\n");
    }

    private void updateUser() throws SQLException {
        System.out.println("\nEnter ID to update: ");
        Integer id = SCANNER.nextInt();
        System.out.println("Enter ID of game chat to update: ");
        Integer gameChatId = SCANNER.nextInt();
        System.out.println("Enter payment ID to update: ");
        Integer paymentID = SCANNER.nextInt();
        System.out.println("Enter security login to update: ");
        String  securityLogin = SCANNER.next();
        User user = getUserInputs();
        user.setId(id);
        user.setGameChatId(gameChatId);
        user.setPaymentId(paymentID);
        user.setSecurityLogin(securityLogin);
        userController.update(user.getId(), user);
        System.out.println("User with ID = " + id + "was updated\n");
    }

    private void deleteUser() throws SQLException {
        System.out.println("\nEnter ID to delete user: ");
        Integer id = SCANNER.nextInt();
        userController.delete(id);
        System.out.println("User with ID = " + id + "was deleted\n");
    }
}
