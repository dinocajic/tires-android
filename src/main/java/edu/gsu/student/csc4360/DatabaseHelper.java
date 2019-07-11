package edu.gsu.student.csc4360;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "tires.db";
    private static final int VERSION = 1;

    private static final class ProductsTable {
        private static final String TABLE = "products";
        private static final String COL_ID = "id";
        private static final String COL_CAT_ID = "category_id";
        private static final String COL_PRODUCT_ID = "product_id";
        private static final String COL_QTY_PER_UNIT = "qty_per_unit";
        private static final String COL_LATEST_COST = "latest_cost_id";
        private static final String COL_LATEST_PRICE = "latest_price_id";
        private static final String COL_ENABLED = "enabled";
    }

    private static final class CategoriesTable {
        private static final String TABLE = "categories";
        private static final String COL_ID = "id";
        private static final String COL_CATEGORY = "category";
        private static final String COL_DETAILS = "details";
        private static final String COL_ENABLED = "enabled";
    }

    // May have to modify since images will be loaded from SD card
    private static final class ProductImagesTable {
        private static final String TABLE = "product_images";
        private static final String COL_ID = "id";
        private static final String COL_PRODUCTS_ID = "products_id";
        private static final String COL_NAME = "name";
        private static final String COL_DESC = "description";
    }

    private static final class ProductCostsTable {
        private static final String TABLE = "product_costs";
        private static final String COL_ID = "id";
        private static final String COL_PROD_ID = "products_id";
        private static final String COL_COST = "cost";
        private static final String COL_FROM_DATE = "from_date";
        private static final String COL_TO_DATE = "to_date";
    }

    private static final class ProductSalesPricesTable {
        private static final String TABLE = "product_sales_prices";
        private static final String COL_ID = "id";
        private static final String COL_PROD_ID = "products_id";
        private static final String COL_PRICE = "price";
        private static final String COL_MSRP = "msrp";
        private static final String COL_FROM_DATE = "from_date";
        private static final String COL_TO_DATE = "to_date";
    }

    private static final class TiresTable {
        private static final String TABLE = "tires";
        private static final String COL_ID = "id";
        private static final String PART_NUM = "part_num";
        private static final String COL_BRAND_ID = "brand_id";
        private static final String COL_MODEL_ID = "model_id";
        private static final String COL_WIDTH = "section_width";
        private static final String COL_RIM_DIAM = "rim_diam";
        private static final String COL_ASPECT_RATIO = "aspect_ratio";
        private static final String COL_CONSTR = "construction";
        private static final String COL_MAX_LOAD = "max_load";
        private static final String COL_MAX_PSI = "max_psi";
        private static final String COL_PLY = "ply";
        private static final String COL_LOAD_RT = "load_rating";
        private static final String COL_SPEED_RT = "speed_rating";
        private static final String COL_IS_DOT_APPR = "is_dot_approved";
        private static final String COL_WEIGHT = "weight";
        private static final String COL_HAS_WARRANTY = "has_warranty";
        private static final String COL_IS_DISCO = "is_discontinued";
        private static final String COL_CREATED_DATE = "created_at";
        private static final String COL_REMOVED_DATE = "removed_at";
    }

    private static final class BrandsTable {
        private static final String TABLE = "brands";
        private static final String COL_ID = "id";
        private static final String COL_NAME = "name";
        private static final String COL_DETAILS = "details";
        private static final String COL_ENABLED = "enabled";
    }

    private static final class ModelsTable {
        private static final String TABLE = "models";
        private static final String COL_ID = "id";
        private static final String COL_NAME = "name";
        private static final String COL_DETAILS = "details";
        private static final String COL_ENABLED = "enabled";
    }

    private static final class TireWarrantiesTable {
        private static final String TABLE = "tire_warranties";
        private static final String COL_ID = "id";
        private static final String COL_TIRES_ID = "tires_id";
        private static final String COL_DETAILS = "details";
        private static final String COL_MAX_TIME = "max_time";
        private static final String COL_MAX_DIST = "max_dist";
        private static final String COL_MIN_TRD_DPTH = "min_tread_depth";
        private static final String COL_ENABLED = "enabled";
        private static final String COL_START_DATE = "start_date";
        private static final String COL_END_DATE = "end_date";
    }

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);

        // To be able to see the database in Device Helper/data/database
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        this.createProductsTable(sqLiteDatabase);
        this.createCategoriesTable(sqLiteDatabase);
        this.createProductImagesTable(sqLiteDatabase);
        this.createProductCostsTable(sqLiteDatabase);
        this.createProductSalesPricesTableI(sqLiteDatabase);
        this.createTiresTable(sqLiteDatabase);
        this.createBrandsTable(sqLiteDatabase);
        this.createModelsTable(sqLiteDatabase);
        this.createTireWarrantiesTable(sqLiteDatabase);
    }

    private void createProductsTable(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "create table " + ProductsTable.TABLE + " (" +
                        ProductsTable.COL_ID + " integer primary key autoincrement, " +
                        ProductsTable.COL_PRODUCT_ID + " integer, " +
                        ProductsTable.COL_CAT_ID + " integer, " +
                        ProductsTable.COL_QTY_PER_UNIT + " text, " +
                        ProductsTable.COL_LATEST_COST + " integer, " +
                        ProductsTable.COL_LATEST_PRICE + " integer, " +
                        ProductsTable.COL_ENABLED + " integer" +
                        ")"
        );
    }

    private void createCategoriesTable(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "create table " + CategoriesTable.TABLE + " (" +
                        CategoriesTable.COL_ID + " integer primary key autoincrement, " +
                        CategoriesTable.COL_CATEGORY + " text, " +
                        CategoriesTable.COL_DETAILS + " text, " +
                        CategoriesTable.COL_ENABLED + " integer" +
                        ")"
        );
    }

    private void createProductImagesTable(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "create table " + ProductImagesTable.TABLE + " (" +
                        ProductImagesTable.COL_ID + " integer primary key autoincrement, " +
                        ProductImagesTable.COL_PRODUCTS_ID + " integer, " +
                        ProductImagesTable.COL_NAME + " text, " +
                        ProductImagesTable.COL_DESC + " text" +
                        ")"
        );
    }

    private void createProductCostsTable(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "create table " + ProductCostsTable.TABLE + " (" +
                        ProductCostsTable.COL_ID + " integer primary key autoincrement, " +
                        ProductCostsTable.COL_PROD_ID + " integer, " +
                        ProductCostsTable.COL_COST + " text, " +
                        ProductCostsTable.COL_FROM_DATE + " text, " +
                        ProductCostsTable.COL_TO_DATE + " text" +
                        ")"
        );
    }

    private void createProductSalesPricesTableI(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "create table " + ProductSalesPricesTable.TABLE + " (" +
                        ProductSalesPricesTable.COL_ID + " integer primary key autoincrement, " +
                        ProductSalesPricesTable.COL_PROD_ID + " integer, " +
                        ProductSalesPricesTable.COL_PRICE + " text, " +
                        ProductSalesPricesTable.COL_MSRP + " text, " +
                        ProductSalesPricesTable.COL_FROM_DATE + " text, " +
                        ProductSalesPricesTable.COL_TO_DATE + " text" +
                        ")"
        );
    }

    private void createTiresTable(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "create table " + TiresTable.TABLE + " (" +
                        TiresTable.COL_ID + " integer primary key autoincrement, " +
                        TiresTable.PART_NUM + " text, " +
                        TiresTable.COL_BRAND_ID + " integer, " +
                        TiresTable.COL_MODEL_ID + " integer, " +
                        TiresTable.COL_WIDTH + " text, " +
                        TiresTable.COL_ASPECT_RATIO + " text, " +
                        TiresTable.COL_RIM_DIAM + " text, " +
                        TiresTable.COL_CONSTR + " text, " +
                        TiresTable.COL_MAX_LOAD + " text, " +
                        TiresTable.COL_MAX_PSI + " text, " +
                        TiresTable.COL_PLY + " text, " +
                        TiresTable.COL_LOAD_RT + " text, " +
                        TiresTable.COL_SPEED_RT + " text, " +
                        TiresTable.COL_IS_DOT_APPR + " integer, " +
                        TiresTable.COL_WEIGHT + " text, " +
                        TiresTable.COL_HAS_WARRANTY + " integer, " +
                        TiresTable.COL_IS_DISCO + " integer, " +
                        TiresTable.COL_CREATED_DATE + " text, " +
                        TiresTable.COL_REMOVED_DATE + " text" +
                        ")"
        );
    }

    private void createBrandsTable(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "create table " + BrandsTable.TABLE + " (" +
                        BrandsTable.COL_ID + " integer primary key autoincrement, " +
                        BrandsTable.COL_NAME + " text, " +
                        BrandsTable.COL_DETAILS + " text, " +
                        BrandsTable.COL_ENABLED + " integer" +
                        ")"
        );
    }

    private void createModelsTable(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "create table " + ModelsTable.TABLE + " (" +
                        ModelsTable.COL_ID + " integer primary key autoincrement, " +
                        ModelsTable.COL_NAME + " text, " +
                        ModelsTable.COL_DETAILS + " text, " +
                        ModelsTable.COL_ENABLED + " integer" +
                        ")"
        );
    }

    private void createTireWarrantiesTable(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "create table " + TireWarrantiesTable.TABLE + " (" +
                        TireWarrantiesTable.COL_ID + " integer primary key autoincrement, " +
                        TireWarrantiesTable.COL_TIRES_ID + " integer, " +
                        TireWarrantiesTable.COL_DETAILS + " text, " +
                        TireWarrantiesTable.COL_MAX_TIME + " text, " +
                        TireWarrantiesTable.COL_MAX_DIST + " text, " +
                        TireWarrantiesTable.COL_MIN_TRD_DPTH + " text, " +
                        TireWarrantiesTable.COL_ENABLED + " integer, " +
                        TireWarrantiesTable.COL_START_DATE + " text, " +
                        TireWarrantiesTable.COL_END_DATE + " text" +
                        ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ProductsTable.TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + CategoriesTable.TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ProductImagesTable.TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ProductCostsTable.TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ProductSalesPricesTable.TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TiresTable.TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + BrandsTable.TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ModelsTable.TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TireWarrantiesTable.TABLE);

        onCreate(sqLiteDatabase);
    }

    public void insert(Tire tire) {
        SQLiteDatabase db = this.getWritableDatabase();

        Brands brand = tire.getBrand();
        Models model = tire.getModel();

        ContentValues tireValues = new ContentValues();
        tireValues.put(TiresTable.PART_NUM, tire.getPart_number());
        tireValues.put(TiresTable.COL_BRAND_ID, brand.getId());
        tireValues.put(TiresTable.COL_MODEL_ID, model.getId());
        tireValues.put(TiresTable.COL_WIDTH, tire.getWidth());
        tireValues.put(TiresTable.COL_RIM_DIAM, tire.getWheel_diameter());
        tireValues.put(TiresTable.COL_ASPECT_RATIO, tire.getAspect_ratio());
        tireValues.put(TiresTable.COL_CONSTR, tire.getConstruction());
        tireValues.put(TiresTable.COL_MAX_LOAD, tire.getMax_load());
        tireValues.put(TiresTable.COL_MAX_PSI, tire.getMax_psi());
        tireValues.put(TiresTable.COL_PLY, tire.getPly());
        tireValues.put(TiresTable.COL_LOAD_RT, tire.getLoad_rating());
        tireValues.put(TiresTable.COL_SPEED_RT, tire.getSpeed_rating());
        tireValues.put(TiresTable.COL_IS_DOT_APPR, tire.getIs_dot_approved());
        tireValues.put(TiresTable.COL_WEIGHT, tire.getWeight());
        tireValues.put(TiresTable.COL_HAS_WARRANTY, tire.getHas_warranty());
        tireValues.put(TiresTable.COL_IS_DISCO, tire.getIs_discontinued());
        long tireId = db.insert(TiresTable.TABLE, null, tireValues);

        ContentValues productImageValues = new ContentValues();
        productImageValues.put(ProductImagesTable.COL_PRODUCTS_ID, tireId);
        productImageValues.put(ProductImagesTable.COL_NAME, tire.getImage());
        db.insert(ProductImagesTable.TABLE, null, productImageValues);


        ContentValues productValues = new ContentValues();
        productValues.put(ProductsTable.COL_PRODUCT_ID, tireId);
        productValues.put(ProductsTable.COL_QTY_PER_UNIT, tire.getQty_per_unit());
        long productsId = db.insert(ProductsTable.TABLE, null, productValues);


        ContentValues productCostsValues = new ContentValues();
        productCostsValues.put(ProductCostsTable.COL_PROD_ID, productsId);
        productCostsValues.put(ProductCostsTable.COL_COST, tire.getCost());
        long productCostsId = db.insert(ProductCostsTable.TABLE, null, productCostsValues);

        productValues.put(ProductsTable.COL_LATEST_COST, productCostsId);
        db.update(ProductsTable.TABLE, productValues, ProductsTable.COL_ID+"="+productsId, null);

    }

    public void modifyProduct(Tire tire, int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        Brands brand = tire.getBrand();
        Models model = tire.getModel();

        ContentValues tireValues = new ContentValues();
        tireValues.put(TiresTable.PART_NUM, tire.getPart_number());
        tireValues.put(TiresTable.COL_BRAND_ID, brand.getId());
        tireValues.put(TiresTable.COL_MODEL_ID, model.getId());
        tireValues.put(TiresTable.COL_WIDTH, tire.getWidth());
        tireValues.put(TiresTable.COL_RIM_DIAM, tire.getWheel_diameter());
        tireValues.put(TiresTable.COL_ASPECT_RATIO, tire.getAspect_ratio());
        tireValues.put(TiresTable.COL_CONSTR, tire.getConstruction());
        tireValues.put(TiresTable.COL_MAX_LOAD, tire.getMax_load());
        tireValues.put(TiresTable.COL_MAX_PSI, tire.getMax_psi());
        tireValues.put(TiresTable.COL_PLY, tire.getPly());
        tireValues.put(TiresTable.COL_LOAD_RT, tire.getLoad_rating());
        tireValues.put(TiresTable.COL_SPEED_RT, tire.getSpeed_rating());
        tireValues.put(TiresTable.COL_IS_DOT_APPR, tire.getIs_dot_approved());
        tireValues.put(TiresTable.COL_WEIGHT, tire.getWeight());
        tireValues.put(TiresTable.COL_HAS_WARRANTY, tire.getHas_warranty());
        tireValues.put(TiresTable.COL_IS_DISCO, tire.getIs_discontinued());
        db.update(TiresTable.TABLE, tireValues, TiresTable.COL_ID+"="+tire.getId(), null);

        ContentValues productImageValues = new ContentValues();
        productImageValues.put(ProductImagesTable.COL_NAME, tire.getImage());
        db.update(ProductImagesTable.TABLE, productImageValues, ProductImagesTable.COL_ID+"="+tire.getImageId());

        ContentValues productValues = new ContentValues();
        productValues.put(ProductsTable.COL_QTY_PER_UNIT, tire.getQty_per_unit());
        db.update(ProductsTable.TABLE, productValues, ProductsTable.COL_ID+"="+tire.getProductsId(), null);

        ContentValues productCostsValues = new ContentValues();
        productCostsValues.put(ProductCostsTable.COL_COST, tire.getCost());
        db.update(ProductCostsTable.TABLE, productCostsValues, ProductCostsTable.COL_ID+"="+tire.getLatestCostId(), null);

    }

    public void delete(int product_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TiresTable.TABLE + " WHERE " + TiresTable.COL_ID + " = " + product_id + ";");
    }

    public Brands getBrand(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor queryCursor = db.rawQuery("SELECT * FROM " + BrandsTable.TABLE + " WHERE " +
                BrandsTable.COL_ID + " = " + id + ";", null);

        if (queryCursor.getCount() == 0) {
            return null;
        }

        queryCursor.moveToFirst();

        Brands brand = new Brands();
        brand.setName(queryCursor.getString(queryCursor.getColumnIndex(BrandsTable.COL_NAME)));
        brand.setDetails(queryCursor.getString(queryCursor.getColumnIndex(BrandsTable.COL_DETAILS)));
        brand.setEnabled(queryCursor.getInt(queryCursor.getColumnIndex(BrandsTable.COL_ENABLED)));

        queryCursor.close();

        return brand;
    }

    public Brands[] getBrands() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor queryCursor = db.rawQuery("SELECT * FROM " + BrandsTable.TABLE + ";", null);

        Brands[] brands = new Brands[queryCursor.getCount()];
        int i = 0;

        queryCursor.moveToFirst();
        while (!queryCursor.isAfterLast()) {
            Brands brand = new Brands();
            brand.setName(queryCursor.getString(queryCursor.getColumnIndex(BrandsTable.COL_NAME)));
            brand.setDetails(queryCursor.getString(queryCursor.getColumnIndex(BrandsTable.COL_DETAILS)));
            brand.setEnabled(queryCursor.getInt(queryCursor.getColumnIndex(BrandsTable.COL_ENABLED)));

            brands[i] = brand;
            i++;
            queryCursor.moveToNext();
        }
        queryCursor.close();

        return brands;
    }

    public Models getModel(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor queryCursor = db.rawQuery("SELECT * FROM " + ModelsTable.TABLE + " WHERE " +
                ModelsTable.COL_ID + " = " + id + ";", null);

        if (queryCursor.getCount() == 0) {
            return null;
        }

        queryCursor.moveToFirst();

        Models model = new Models();
        model.setName(queryCursor.getString(queryCursor.getColumnIndex(ModelsTable.COL_NAME)));
        model.setDetails(queryCursor.getString(queryCursor.getColumnIndex(ModelsTable.COL_DETAILS)));
        model.setEnabled(queryCursor.getInt(queryCursor.getColumnIndex(ModelsTable.COL_ENABLED)));

        queryCursor.close();

        return model;
    }

    public Models[] getModels() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor queryCursor = db.rawQuery("SELECT * FROM " + ModelsTable.TABLE + ";", null);

        Models[] models = new Models[queryCursor.getCount()];
        int i = 0;

        queryCursor.moveToFirst();
        while (!queryCursor.isAfterLast()) {
            Models model = new Models();
            model.setName(queryCursor.getString(queryCursor.getColumnIndex(ModelsTable.COL_NAME)));
            model.setDetails(queryCursor.getString(queryCursor.getColumnIndex(ModelsTable.COL_DETAILS)));
            model.setEnabled(queryCursor.getInt(queryCursor.getColumnIndex(ModelsTable.COL_ENABLED)));

            models[i] = model;

            i++;
            queryCursor.moveToNext();
        }
        queryCursor.close();

        return models;
    }

    public String getImage(int productId) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor queryCursor = db.rawQuery("SELECT * FROM " + ProductImagesTable.TABLE + " WHERE " +
                ProductImagesTable.COL_PRODUCTS_ID + " = " + productId + ";", null);

        if (queryCursor.getCount() == 0) {
            return "";
        }

        queryCursor.moveToFirst();

        String image = queryCursor.getString(queryCursor.getColumnIndex(ProductImagesTable.COL_NAME))

        queryCursor.close();

        return image;
    }

    public boolean partNumberExists(String partNumber) {
        return (getProductByPartNumber(partNumber) != null);
    }

    public Tire getProductByPartNumber(String partNumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor queryCursor = db.rawQuery("SELECT * FROM " + TiresTable.TABLE + " WHERE " +
                TiresTable.PART_NUM + " = " + partNumber + ";", null);

        if (queryCursor.getCount() == 0) {
            return null;
        }

        Tire tire = new Tire();

        queryCursor.moveToFirst();


        tire.setId(queryCursor.getInt(queryCursor.getColumnIndex(TiresTable.COL_ID)));
        tire.setPart_number(queryCursor.getString(queryCursor.getColumnIndex(TiresTable.PART_NUM)));
        tire.setWidth(queryCursor.getString(queryCursor.getColumnIndex(TiresTable.COL_WIDTH)));
        tire.setConstruction(queryCursor.getString(queryCursor.getColumnIndex(TiresTable.COL_CONSTR)));
        tire.setWheel_diameter(queryCursor.getString(queryCursor.getColumnIndex(TiresTable.COL_RIM_DIAM)));
        tire.setAspect_ratio(queryCursor.getString(queryCursor.getColumnIndex(TiresTable.COL_ASPECT_RATIO)));
        tire.setMax_load(queryCursor.getString(queryCursor.getColumnIndex(TiresTable.COL_MAX_LOAD)));
        tire.setMax_psi(queryCursor.getString(queryCursor.getColumnIndex(TiresTable.COL_MAX_PSI)));
        tire.setLoad_rating(queryCursor.getString(queryCursor.getColumnIndex(TiresTable.COL_LOAD_RT)));
        tire.setSpeed_rating(queryCursor.getString(queryCursor.getColumnIndex(TiresTable.COL_SPEED_RT)));
        tire.setWeight(queryCursor.getString(queryCursor.getColumnIndex(TiresTable.COL_WEIGHT)));

        tire.setHas_warranty(queryCursor.getInt(queryCursor.getColumnIndex(TiresTable.COL_HAS_WARRANTY)) != 0);
        tire.setIs_dot_approved(queryCursor.getInt(queryCursor.getColumnIndex(TiresTable.COL_IS_DOT_APPR)) != 0);
        tire.setIs_discontinued(queryCursor.getInt(queryCursor.getColumnIndex(TiresTable.COL_IS_DISCO)) != 0);

        int brandId = queryCursor.getInt(queryCursor.getColumnIndex(TiresTable.COL_BRAND_ID);
        int modelId = queryCursor.getInt(queryCursor.getColumnIndex(TiresTable.COL_MODEL_ID);

        Brands brand = getBrand(brandId);
        if (brand != null) {
            tire.setBrand(brand);
        }

        Models model = getModel(modelId);
        if (model != null) {
            tire.setModel(model);
        }

        tire.setImage(getImage(tire.getId()));

        Cursor productsCursor = db.rawQuery("SELECT * FROM " + ProductsTable.TABLE + " WHERE " +
                ProductsTable.COL_PRODUCT_ID + " = " + tire.getId() + ";", null);
        if (productsCursor.getCount() > 0) {
            productsCursor.moveToFirst();

            tire.setProductsId(productsCursor.getInt(productsCursor.getColumnIndex(ProductsTable.COL_ID))
            tire.setQty_per_unit(productsCursor.getString(productsCursor.getColumnIndex(ProductsTable.COL_QTY_PER_UNIT)));
            tire.setLatestCostId(productsCursor.getInt(productsCursor.getColumnIndex(ProductsTable.COL_LATEST_COST));

            Cursor productCostCursor = db.rawQuery("SELECT * FROM " + ProductCostsTable.TABLE + " WHERE " +
                    ProductCostsTable.COL_ID + " = " + tire.getLatestCostId() + ";", null);
            if (productCostCursor.getCount() > 0) {
                tire.setCost(queryCursor.getString(queryCursor.getColumnIndex(ProductCostsTable.COL_COST)));
            }
            productCostCursor.close();
        }
        productsCursor.close();

        queryCursor.close();

        return tire;

    }

    // todo add sql join for brand and model and add brand/model to tire
    // todo Cost, Image, Sales, Quantity have no database column
    public Tire[] getProducts(String searchParam) {
        String[] parameters = searchParam.split("/|R");
        if (parameters.length != 3) {
            return new Tire[] {};
        }

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor queryCursor = db.rawQuery("SELECT * FROM " + TiresTable.TABLE + " WHERE " +
                TiresTable.COL_WIDTH + " = " + parameters[0] + " AND " +
                TiresTable.COL_ASPECT_RATIO + " = " + parameters[1] + " AND " +
                TiresTable.COL_RIM_DIAM + " = " + parameters[2] + ";", null);

        Tire[] tires = new Tire[queryCursor.getCount()];
        int i = 0;

        queryCursor.moveToFirst();
        while (!queryCursor.isAfterLast()) {
            Tire tire = new Tire();

            tire.setId(queryCursor.getInt(queryCursor.getColumnIndex(TiresTable.COL_ID)));
            tire.setPart_number(queryCursor.getString(queryCursor.getColumnIndex(TiresTable.PART_NUM)));
            tire.setWidth(queryCursor.getString(queryCursor.getColumnIndex(TiresTable.COL_WIDTH)));
            tire.setConstruction(queryCursor.getString(queryCursor.getColumnIndex(TiresTable.COL_CONSTR)));
            tire.setWheel_diameter(queryCursor.getString(queryCursor.getColumnIndex(TiresTable.COL_RIM_DIAM)));
            tire.setAspect_ratio(queryCursor.getString(queryCursor.getColumnIndex(TiresTable.COL_ASPECT_RATIO)));
            tire.setMax_load(queryCursor.getString(queryCursor.getColumnIndex(TiresTable.COL_MAX_LOAD)));

            tire.setMax_psi(queryCursor.getString(queryCursor.getColumnIndex(TiresTable.COL_MAX_PSI)));
            tire.setLoad_rating(queryCursor.getString(queryCursor.getColumnIndex(TiresTable.COL_LOAD_RT)));
            tire.setSpeed_rating(queryCursor.getString(queryCursor.getColumnIndex(TiresTable.COL_SPEED_RT)));
            tire.setWeight(queryCursor.getString(queryCursor.getColumnIndex(TiresTable.COL_WEIGHT)));

            tire.setHas_warranty(queryCursor.getInt(queryCursor.getColumnIndex(TiresTable.COL_HAS_WARRANTY)) != 0);
            tire.setIs_dot_approved(queryCursor.getInt(queryCursor.getColumnIndex(TiresTable.COL_IS_DOT_APPR)) != 0);
            tire.setIs_discontinued(queryCursor.getInt(queryCursor.getColumnIndex(TiresTable.COL_IS_DISCO)) != 0);

            int brandId = queryCursor.getInt(queryCursor.getColumnIndex(TiresTable.COL_BRAND_ID);
            int modelId = queryCursor.getInt(queryCursor.getColumnIndex(TiresTable.COL_MODEL_ID);

            Brands brand = getBrand(brandId);
            if (brand != null) {
                tire.setBrand(brand);
            }

            Models model = getModel(modelId);
            if (model != null) {
                tire.setModel(model);
            }

            tire.setImage(getImage(tire.getId()));

            Cursor productsCursor = db.rawQuery("SELECT * FROM " + ProductsTable.TABLE + " WHERE " +
                    ProductsTable.COL_PRODUCT_ID + " = " + tire.getId() + ";", null);
            if (productsCursor.getCount() > 0) {
                productsCursor.moveToFirst();

                tire.setQty_per_unit(productsCursor.getString(productsCursor.getColumnIndex(ProductsTable.COL_QTY_PER_UNIT)));
                int costId = productsCursor.getInt(productsCursor.getColumnIndex(ProductsTable.COL_LATEST_COST);

                Cursor productCostCursor = db.rawQuery("SELECT * FROM " + ProductCostsTable.TABLE + " WHERE " +
                        ProductCostsTable.COL_ID + " = " + costId + ";", null);
                if (productCostCursor.getCount() > 0) {
                    tire.setCost(queryCursor.getString(queryCursor.getColumnIndex(ProductCostsTable.COL_COST)));
                }
                productCostCursor.close();
            }
            productsCursor.close();

            tires[i] = tire;
            i++;

            queryCursor.moveToNext();
        }
        queryCursor.close();

        return tires;
    }
}
