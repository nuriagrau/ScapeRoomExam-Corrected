package finishedScapeRoom;

import finishedScapeRoom.Exceptions.*;
import finishedScapeRoom.Room.Room;

import java.util.ArrayList;

import static finishedScapeRoom.Helpers.InputHelper.inputInt;
import static finishedScapeRoom.Inventory.Clue.ClueManager.addClue;
import static finishedScapeRoom.Inventory.InventoryManager.*;
import static finishedScapeRoom.Inventory.Object.ObjectManager.addObject;
import static finishedScapeRoom.Room.RoomManager.createANewRoom;


/*TODO
La clase AppMenu podría centrarse exclusivamente en la interacción con el
usuario (AppMenu) y delegar las operaciones de negocio a clases específicas (por ejemplo, RoomManager, ClueManager, etc.).
 */
public class AppMenu {

    /*Funcionalidades Mínimas:
        1. Crear una nueva sala.
        2. Añadir pistas a una sala específica.
        3. Introducir objetos de decoración para ambientar las salas.
        4. Mostrar el inventario actualizado, incluyendo cantidades disponibles y valor total.
        5. Permitir la retirada de elementos del inventario.*/

    public static ArrayList<Room> scapeRoomsList = new ArrayList<>();

    public static void startMenu() {
        int option = 0;
        String message = "";
        do {
            message = "";
            option = inputInt("Welcome to La Sala De Los Enigmas. Choose an option:\n" +
                    "0. Exit\n" +
                    "1. Create a new room\n" +
                    "2. Add clues to a room\n" +
                    "3. Add decoration objects to a room\n" +
                    "4. Show inventory\n" +
                    "5. Remove inventory items\n");

            switch (option) {
                case 0:
                    message = "You are leaving a Sala De Los Enigmas.... Aloha!";
                    break;
                case 1:
                    try {
                        message = createANewRoom();
                    } catch (RoomAlreadyExistsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        message = addClue();
                    } catch (RoomNotFoundException re) {
                        System.out.println(re.getMessage());
                    } catch (InventoryItemAlreadyExists ie) {
                        System.out.println(ie.getMessage());
                    }

                    break;
                case 3:
                    try {
                        message = addObject();
                    } catch (RoomNotFoundException re) {
                        System.out.println(re.getMessage());
                    } catch (InventoryItemAlreadyExists ie) {
                        System.out.println(ie.getMessage());
                    }
                    break;
                case 4:
                    try {
                        message = showInventory();
                    } catch (RoomNotFoundException re) {
                        System.out.println(re.getMessage());
                    } catch (EmptyRoomException er) {
                        System.out.println(er.getMessage());
                    }
                    break;
                case 5:
                    try {
                        message = removeInventoryItem();
                    } catch (RoomNotFoundException re) {
                        System.out.println(re.getMessage());
                    } catch (EmptyRoomException er) {
                        System.out.println(er.getMessage());
                    } catch (InventoryItemNotFound nf) {
                        System.out.println(nf.getMessage());
                    }
                    break;
            }
            System.out.println(message);
        } while (option != 0);
    }


}

