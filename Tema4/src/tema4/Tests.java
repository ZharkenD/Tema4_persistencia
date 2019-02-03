package tema4;

public class Tests {
    
    //TESTS PARA USAR EN EL MAIN
    
    /*  
        for (int inc = 1; inc < 7; inc++) {
            Article article = new Article("article" + inc, "Articulo de prueba " + inc + ".");
            gd.obtenerArticulo(article);
        }

        String[] udms = {"ml", "g", "l"};
        for (int inc = 0; inc < 3; inc++) {
            UnitatDeMesura udm = new UnitatDeMesura(udms[inc]);
            gd.obtenerUDM(udm);
        }

        String[] udms = {"ml", "g", "l"};
        String[] tipos = {"Carton", "Plastico", "Vidrio"};
        for (int inc = 0; inc < 3; inc++) {
            UnitatDeMesura udm = new UnitatDeMesura(udms[inc]);
            Envas envas = new Envas(tipos[inc], inc + 1, udm);
            gd.obtenerEnvase(envas);
        }

        Magatzem magatzem = new Magatzem("almacen1", "Descripcion de almacen 1.");
        gd.obtenerAlmacen(magatzem);

        String[] marcas = {"Adidas", "Gallo", "Hacendado", "Genius", "Nike", "Corsair", "Asus", "Tobias SL", "HP", "Ferrari", "Yamaha"};
        int[] id = {3,5,2,1,6,3,1,5,1,6};
        for (int inc = 0; inc < 10; inc++) {
            Article article = new Article("article" + id[inc], "Articulo de prueba " + id[inc] + ".");
            Producte producte = new Producte(article, marcas[inc], (double) inc);
            gd.obtenerProducto(producte);
        }

        Magatzem magatzem = new Magatzem("almacen1", "Descripcion de almacen 1.");
        
        String[] marcas = {"Adidas", "Gallo", "Hacendado", "Genius", "Nike", 
            "Corsair", "Asus", "Tobias SL", "HP", "Ferrari", "Yamaha"};
        int[] id = {3,5,2,1,6,3,1,5,1,6};
        for (int inc = 0; inc < 10; inc++) {
            Article article = new Article("article" + id[inc], "Articulo de prueba " + id[inc] + ".");
            Producte producte = new Producte(article, marcas[inc], (double) inc);
            magatzem.assignarEstoc(producte, (double) (inc + 1) * 2);
        }
        
        gd.actualizarObjeto(magatzem);
        gd.obtenerProductosPorAlmacen(magatzem, 20);

        Magatzem magatzem = new Magatzem("almacen1", "Descripcion de almacen 1.");
        gd.obtenerAlmacen(magatzem);

        Article article = new Article("article1", "Articulo de prueba 1.");
        
        for(Producte producte : gd.obtenerProductosPorAlmacen(magatzem, 10)) {
            
            magatzem.incrementarEstocProducte(producte, 2.00);
            
        }

        gd.actualizarObjeto(magatzem)
 */
    
}
