/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author del.sistemas_res
 */
public class DCategorias {
    private int Id;
    private String Detalle;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getDetalle() {
        return Detalle;
    }

    public void setDetalle(String Detalle) {
        this.Detalle = Detalle;
    }

    public DCategorias(int Id, String Detalle) {
        this.Id = Id;
        this.Detalle = Detalle;
    }

    public DCategorias() {
    }
}
