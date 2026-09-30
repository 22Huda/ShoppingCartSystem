/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public interface Borrowable {

    /**
     * Mark the item as checked out (not available).
     * @throws IllegalStateException if the item is already checked out.
     */
    void checkOut() throws IllegalStateException;

    /**
     * Mark the item as checked in (available again).
     * @throws IllegalStateException if the item is already available.
     */
    void checkIn() throws IllegalStateException;

    /**
     * Check if the item is currently available.
     * @return true if available, false otherwise.
     */
    boolean isAvailable();
}
