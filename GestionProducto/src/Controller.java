package GestionProducto;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    @FXML
    private TableView<Producto> tabla;

    @FXML
    private TableColumn<Producto,String> colNombre;

    @FXML
    private TableColumn<Producto,Double> colPrecio;

    @FXML
    private TableColumn<Producto,Integer> colCantidad;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtPrecio;

    @FXML
    private TextField txtCantidad;

    private List<Producto> productos = new ArrayList<>();


    @FXML
    public void initialize(){

        colNombre.setCellValueFactory(data -> data.getValue().nombreProperty());

        colPrecio.setCellValueFactory(data ->
            data.getValue().precioProperty().asObject());

        colCantidad.setCellValueFactory(data ->
            data.getValue().cantidadProperty().asObject());

    }

    @FXML
    private void agregarProducto(){

        String nombre = txtNombre.getText();

        try{

            double precio = Double.parseDouble(txtPrecio.getText());
            int cantidad = Integer.parseInt(txtCantidad.getText());

            Producto p = new Producto(nombre,precio,cantidad);

            productos.add(p);

            tabla.getItems().add(p);

            txtNombre.clear();
            txtPrecio.clear();
            txtCantidad.clear();

        }catch(Exception e){

            System.out.println("Error: Precio o cantidad no validos");

        }

    }

    @FXML
    private void eliminarProducto(){

        Producto seleccionado = tabla.getSelectionModel().getSelectedItem();

        if(seleccionado != null){

            productos.remove(seleccionado);

            tabla.getItems().remove(seleccionado);

        }

    }

}