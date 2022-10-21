/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package workbot_jobtn.services;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author youcef
 * @param <T>
 */
public interface InterfaceServiceCategorie<T> {
    
    void ajouter(T t) throws SQLException;
    boolean modifier(T t) throws SQLException;
    boolean supprimer(T t) throws SQLException;
    List<T> afficherTout() throws SQLException;
    T afficher(int i) throws SQLException;
}
