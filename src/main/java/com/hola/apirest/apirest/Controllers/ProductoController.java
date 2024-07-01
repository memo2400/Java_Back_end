package com.hola.apirest.apirest.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hola.apirest.apirest.Repositories.Producto_Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hola.apirest.apirest.Entities.Producto;

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
        return
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
