package com.hola.apirest.apirest.Controllers;

import java.util.List;

import com.hola.apirest.apirest.Repositories.Producto_Repository;
import com.hola.apirest.apirest.Entities.Producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;

//import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



/*
 * Pondremos tosas las direcciones
 * para que nuestros clientes consuman datos
 * 
 * estructura back end que da las urls
 * 
 * /productos, se ira a la nuestra BD, donde estaran
 * los productos
 */

@RestController
@RequestMapping ("/productos")
 public class ProductoController {

    // hace una instancia del los repos de forma automatica
    // para ahorrar codigo
    @Autowired
    private Producto_Repository productoRepository;


    // List sale de java.util
    @GetMapping
    public List<Producto> getAllProducts(){
        return productoRepository.findAll();
    }

    /*
     * Recibimos un ID
     * Si no encuentra nada hacemos un error
     * Si si lo encuientra lo modificamos
     */
    @GetMapping("/{id}")
    public Producto obtenerProductoPorID(@PathVariable Long id, @RequestBody Producto detallesProducto){
        return productoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException ("No encontramos el prducto de ID " + id));
        
    }

    /*
     * GUARDADO
     * 
     * El request significa que el cliente pedira datos a la BD
     * de nuestra classe producto de carpeta entities, cargaremos 
     * p brindaremos todos los aprametros necesarios exepto el ID
     * Guardaremos todo aqui
     */
    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        // TODO: process POST request
        // guardamos el producto que recibimos en el parametro
        
        return productoRepository.save(producto);
    }
    
    /*
     * ACTUALIZACION
     * 
     * Si no encuentra nada hacemos un error
     * Si si lo encuientra lo modificamos
     * 
     * Se crea una variable nueva
     * se modifica el precio y nombre por los prametros que llegan
     * guarda al final la variable en nuestro repositorio BD
     */

     @PutMapping("/{id}")
     public Producto updateProducto(@PathVariable Long id, @RequestBody Producto detallesProducto) {
        //TODO: process PUT request
         
         Producto productoo = productoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException ("No encontramos el prducto de ID " + id));
         
        productoo.setNombre(detallesProducto.getNombre());
        productoo.setPrecio(detallesProducto.getPrecio());

        return productoRepository.save(productoo);
     }

     /*
      * Se suele retornar el procuto eliminado, pero esta vez
      regresaremos una frase
      */
    
    @DeleteMapping ("/{id}")
    public String borrarProducto (@PathVariable Long id){
        Producto productoABorrar = productoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("no se pudo borrar massivamente el producto " + id)); 

        productoRepository.delete(productoABorrar);
        return "se borro el producto " + id + "FHD";

    }
}



/*
 * http nos manda datos entrre cosas, es el protocolo en que se envia
 *  get = recibe cosas de un server
 *  post = crear un nuevo recursos
 *  put actualizar o reemplazar versiona anterior
 *  patch actualizar una parte del producto
 *  delete = para borrar
 * 
 * 
 * Rest brinda los datos en JSON  (api rest = forma en la que trabaja el envio de la informacion)
 */
