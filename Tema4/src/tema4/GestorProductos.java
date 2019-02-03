package tema4;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.query.Constraint;
import com.db4o.query.Predicate;
import com.db4o.query.Query;
import java.util.ArrayList;
import java.util.List;

public class GestorProductos {

    // Atributos
    private ObjectContainer db;

    // Constructor
    public GestorProductos() {

    }

    // Metodos
    public void abrirBase(String db4ofilename) {
        try {
            db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), db4ofilename);
            System.out.println("Base de datos abierta.");
        } catch (Exception e) {
            System.out.println("La base de datos no ha podido abrirse.");
        }
    }

    public void cerrarBase() {
        if (!db.ext().isClosed()) {
            db.commit();
            db.close();
            System.out.println("Base de datos.");
        } else {
            System.out.println("La base de datos ya esta cerrada.");
        }
    }

    public void actualizarObjeto(Object o) {
        try {
            db.store(o);
            db.commit();
            System.out.println("Se ha actualizado el objeto.");
        } catch (Exception e) {
            System.out.println("No se ha podido actualizar el objeto.");
        }
    }

    public void eliminarObjeto(Object o) {
        try {
            db.delete(o);
            System.out.println("Se ha borrado el objeto.");
        } catch (Exception e) {
            System.out.println("No se ha podido borrar el objeto.");
        }
        db.commit();
    }

    public Article obtenerArticulo(Article article) throws Exception {
        ObjectSet<Article> set = db.queryByExample(article);
        if (set.hasNext()) {
            Article ret = set.next();
            if (!set.hasNext()) {
                System.out.println("Se ha encontrado el articulo " + ret.getId() + ".");
                return ret; // Detener la ejecucion del metodo.
            } else {
                System.out.println("No se ha podido encontrar el articulo.");
                throw new Exception("");
            }
        } else {
            db.store(article);
            db.commit();
            System.out.println("Se ha creado el articulo " + article.getId() + ".");
        }
        return null;
    }

    public Envas obtenerEnvase(Envas envas) throws Exception {
        ObjectSet<Envas> set = db.queryByExample(envas);
        if (set.hasNext()) {
            Envas ret = set.next();
            if (!set.hasNext()) {
                System.out.println("Se ha encontrado el envase " + envas.getTipus() + " " + envas.getQuantitat() + " " + envas.getUnitat().getSimbol() + ".");
                return ret; // Detener la ejecucion del metodo.
            } else {
                System.out.println("No se ha podido encontrar el envase.");
                throw new Exception("");
            }
        } else {
            db.store(envas);
            db.commit();
            System.out.println("Se ha creado el envase " + envas.getTipus() + " " + envas.getQuantitat() + " " + envas.getUnitat().getSimbol() + ".");
        }
        return null;
    }

    public Magatzem obtenerAlmacen(Magatzem magatzem) throws Exception {
        ObjectSet<Magatzem> set = db.queryByExample(magatzem);
        if (set.hasNext()) {
            Magatzem ret = set.next();
            if (!set.hasNext()) {
                System.out.println("Se ha encontrado el almacen.");
                return ret; // Detener la ejecucion del metodo.
            } else {
                System.out.println("No se ha podido encontrar el almacen.");
                throw new Exception("");
            }
        } else {
            db.store(magatzem);
            db.commit();
            System.out.println("Se ha creado el almacen.");
        }
        return null;
    }

    public Producte obtenerProducto(Producte producte) throws Exception {
        ObjectSet<Producte> set = db.queryByExample(producte);
        if (set.hasNext()) {
            Producte ret = set.next();
            if (!set.hasNext()) {
                System.out.println("Se ha encontrado el producto " + producte.getArticle().getId() + " " + producte.getMarca() + " " + producte.getPreu() + ".");
                return ret; // Detener la ejecucion del metodo.
            } else {
                System.out.println("No se ha podido encontrar el producto.");
                throw new Exception("");
            }
        } else {
            db.store(producte);
            db.commit();
            System.out.println("Se ha creado el producto " + producte.getArticle().getId() + " " + producte.getMarca() + " " + producte.getPreu() + ".");
        }
        return null;
    }

    public UnitatDeMesura obtenerUDM(UnitatDeMesura udm) throws Exception {
        ObjectSet<UnitatDeMesura> set = db.queryByExample(udm);
        if (set.hasNext()) {
            UnitatDeMesura ret = set.next();
            if (!set.hasNext()) {
                System.out.println("Se ha encontrado la unidad de medicion " + udm.getSimbol() + ".");
                return ret; // Detener la ejecucion del metodo.
            } else {
                System.out.println("No se ha podido encontrar la unidad de medicion.");
                throw new Exception("");
            }
        } else {
            db.store(udm);
            db.commit();
            System.out.println("Se ha creado la unidad de medicion " + udm.getSimbol() + ".");
        }
        return null;
    }

    public List<Article> obtenerArticulos(Article article) throws Exception {
        List<Article> list = new ArrayList<Article>();
        ObjectSet<Article> set = db.query((Class<Article>) article.getClass());

        while (set.hasNext()) {
            Article ret = set.next();
            list.add(ret);
        }

        System.out.println("Se han encontrado " + list.size() + " articulos en la base de datos.");
        return list;
    }

    public List<Envas> obtenerEnvases(Envas envas) throws Exception {

        List<Envas> list = new ArrayList<Envas>();
        ObjectSet<Envas> set = db.query((Class<Envas>) envas.getClass());

        while (set.hasNext()) {
            Envas ret = set.next();
            list.add(ret);
        }

        System.out.println("Se han encontrado " + list.size() + " envases en la base de datos.");
        return list;

    }

    public List<Magatzem> obtenerAlmacenes(Magatzem magatzem) throws Exception {

        List<Magatzem> list = new ArrayList<Magatzem>();
        ObjectSet<Magatzem> set = db.query((Class<Magatzem>) magatzem.getClass());

        while (set.hasNext()) {
            Magatzem ret = set.next();
            list.add(ret);
        }

        System.out.println("Se han encontrado " + list.size() + " almacenes en la base de datos.");
        return list;

    }

    public List<Producte> obtenerProductos(Producte producte) throws Exception {

        List<Producte> list = new ArrayList<Producte>();
        ObjectSet<Producte> set = db.query((Class<Producte>) producte.getClass());

        while (set.hasNext()) {
            Producte ret = set.next();
            list.add(ret);
        }

        System.out.println("Se han encontrado " + list.size() + " productos en la base de datos.");
        return list;

    }

    public List<UnitatDeMesura> obtenerUDMS(UnitatDeMesura udm) throws Exception {

        List<UnitatDeMesura> list = new ArrayList<UnitatDeMesura>();
        ObjectSet<UnitatDeMesura> set = db.query((Class<UnitatDeMesura>) udm.getClass());

        while (set.hasNext()) {
            UnitatDeMesura ret = set.next();
            list.add(ret);
        }

        System.out.println("Se han encontrado " + list.size() + " unidades de medicion en la base de datos.");
        return list;

    }

    public List<Producte> obtenerProductosPorArticulo(Article article) throws Exception {

        Producte producte = new Producte();
        producte.setArticle(article);

        List<Producte> list = new ArrayList<Producte>();
        ObjectSet<Producte> set = db.queryByExample(producte);

        while (set.hasNext()) {
            Producte ret = set.next();
            list.add(ret);
        }

        System.out.println("Se han encontrado " + list.size()
                + " productos en la base de datos que corresponden "
                + "con el articulo indicado.");
        return list;

    }

    public List<Producte> obtenerProductosPorPrecio(String denominacion, double min, double max) throws Exception {

        Query query = db.query();
        query.constrain(Producte.class);

        Constraint constraint = query.descend("article").descend("id").constrain(denominacion).startsWith(false);

        Query node = query.descend("preu");

        node.constrain(min).greater().and(node.constrain(max).smaller()).and(constraint);
        node.orderAscending();
        ObjectSet<Producte> list = query.execute();

        System.out.println("Se han encontrado " + list.size()
                + " productos en la base de datos que corresponden "
                + "con el rango de precios indicado.");
        return list;

    }

    public List<Producte> obtenerProductosPorAlmacen(Magatzem magatzem, double estocMax) {

        List<Producte> list = null;

        list = db.query(new Predicate<Producte>() {
            @Override
            public boolean match(Producte producte) {
                return magatzem.getEstoc(producte).getQuantitat() <= estocMax;
            }
        });

        System.out.println("Se han encontrado " + list.size()
                + " productos en la base de datos que corresponden "
                + "con el estoc y almacen indicados.");
        return list;

    }

    // Main activity
    public static void main(String[] args) throws Exception {

        GestorProductos gd = new GestorProductos();
        gd.abrirBase("db4ofile");
        
        Magatzem magatzem = new Magatzem("almacen1", "Descripcion de almacen 1.");
        gd.obtenerAlmacen(magatzem);

        gd.obtenerAlmacenes(magatzem);

        String[] marcas = {"Adidas", "Gallo", "Hacendado", "Genius", "Nike",
            "Corsair", "Asus", "Tobias SL", "HP", "Ferrari", "Yamaha"};
        int[] id = {3, 5, 2, 1, 6, 3, 1, 5, 1, 6};       
        for (int inc = 0; inc < 10; inc++) {
            Article article = new Article("article" + id[inc], "Articulo de prueba " + id[inc] + ".");
            gd.obtenerArticulo(article);
            article = gd.obtenerArticulo(article);
            Producte producte = new Producte(article, marcas[inc], (double) inc);
            producte = gd.obtenerProducto(producte);
            gd.obtenerAlmacen(magatzem).assignarEstoc(producte, (double) (inc + 1) * 2);
            gd.actualizarObjeto(gd.obtenerAlmacen(magatzem));
        }

        for (Producte producte : gd.obtenerProductosPorAlmacen(gd.obtenerAlmacen(magatzem), 9)) {

            System.out.println("Producte: " + producte.getArticle().getId() + " " 
                            + "Marca: " + producte.getMarca() + " " 
                            + "Estoc: " 
                            + gd.obtenerAlmacen(magatzem).getEstoc(producte).getQuantitat() + ".");
        }

        gd.obtenerAlmacenes(magatzem);

        gd.cerrarBase();

    }

}