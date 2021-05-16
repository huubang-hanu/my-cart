package hanu.a2_1801040021.db;

import android.database.Cursor;
import android.database.CursorWrapper;

import java.util.ArrayList;
import java.util.List;

import hanu.a2_1801040021.models.Product;

public class ProductCursorWrapper extends CursorWrapper {

    public ProductCursorWrapper(Cursor cursor) {
        super(cursor);
    }


    public Product getProduct(){
        long id = getLong(getColumnIndex(DbSchema.OrderTable.Cols.PRODUCT_ID));
        String name = getString(getColumnIndex(DbSchema.OrderTable.Cols.PRODUCT_NAME));
        String thumbnail = getString(getColumnIndex(DbSchema.OrderTable.Cols.THUMBNAIL));
        double unitPrice = getDouble(getColumnIndex(DbSchema.OrderTable.Cols.UNIT_PRICE));
        int quantity = getInt(getColumnIndex(DbSchema.OrderTable.Cols.QUANTITY));

        Product product = new Product(id,name,thumbnail, unitPrice,quantity);
        return product;
    }

    public List<Product> getProducts(){
        List<Product> products = new ArrayList<>();

        moveToFirst();
        while (!isAfterLast()){
            Product product = getProduct();
            products.add(product);

            moveToNext();
        }

        return products;
    }


    public Product getProductByID(){
        Product product = null;
        moveToFirst();
        if(!isAfterLast()){
            product = getProduct();
        }

        return product;
    }
}
