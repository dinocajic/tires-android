package edu.gsu.student.csc4360;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "tires.db";
    private static final int VERSION          = 1;

    private static final class ProductsTable {
        private static final String TABLE            = "products";
        private static final String COL_ID           = "id";
        private static final String COL_CAT_ID       = "category_id";
        private static final String COL_PRODUCT_ID   = "product_id";
        private static final String COL_QTY_PER_UNIT = "qty_per_unit";
        private static final String COL_LATEST_COST  = "latest_cost_id";
        private static final String COL_LATEST_PRICE = "latest_price_id";
        private static final String COL_ENABLED      = "enabled";
    }

    private static final class CategoriesTable {
        private static final String TABLE        = "categories";
        private static final String COL_ID       = "id";
        private static final String COL_CATEGORY = "category";
        private static final String COL_DETAILS  = "details";
        private static final String COL_ENABLED  = "enabled";
    }

    // May have to modify since images will be loaded from SD card
    private static final class ProductImagesTable {
        private static final String TABLE           = "product_images";
        private static final String COL_ID          = "id";
        private static final String COL_PRODUCTS_ID = "products_id";
        private static final String COL_NAME        = "name";
        private static final String COL_DESC        = "description";
    }

    private static final class ProductCostsTable {
        private static final String TABLE         = "product_costs";
        private static final String COL_ID        = "id";
        private static final String COL_PROD_ID   = "products_id";
        private static final String COL_COST      = "cost";
        private static final String COL_FROM_DATE = "from_date";
        private static final String COL_TO_DATE   = "to_date";
    }

    private static final class ProductSalesPricesTable {
        private static final String TABLE         = "product_sales_prices";
        private static final String COL_ID        = "id";
        private static final String COL_PROD_ID   = "products_id";
        private static final String COL_PRICE     = "price";
        private static final String COL_MSRP      = "msrp";
        private static final String COL_FROM_DATE = "from_date";
        private static final String COL_TO_DATE   = "to_date";
    }

    private static final class TiresTable {
        private static final String TABLE            = "tires";
        private static final String COL_ID           = "id";
        private static final String PART_NUM         = "part_num";
        private static final String COL_BRAND_ID     = "brand_id";
        private static final String COL_MODEL_ID     = "model_id";
        private static final String COL_WIDTH        = "section_width";
        private static final String COL_RIM_DIAM     = "rim_diam";
        private static final String COL_ASPECT_RATIO = "aspect_ratio";
        private static final String COL_CONSTR       = "construction";
        private static final String COL_MAX_LOAD     = "max_load";
        private static final String COL_MAX_PSI      = "max_psi";
        private static final String COL_PLY          = "ply";
        private static final String COL_LOAD_RT      = "load_rating";
        private static final String COL_SPEED_RT     = "speed_rating";
        private static final String COL_IS_DOT_APPR  = "is_dot_approved";
        private static final String COL_WEIGHT       = "weight";
        private static final String COL_HAS_WARRANTY = "has_warranty";
        private static final String COL_IS_DISCO     = "is_discontinued";
        private static final String COL_CREATED_DATE = "created_at";
        private static final String COL_REMOVED_DATE = "removed_at";
    }

    private static final class BrandsTable {
        private static final String TABLE       = "brands";
        private static final String COL_ID      = "id";
        private static final String COL_NAME    = "name";
        private static final String COL_DETAILS = "details";
        private static final String COL_ENABLED = "enabled";
    }

    private static final class ModelsTable {
        private static final String TABLE       = "models";
        private static final String COL_ID      = "id";
        private static final String COL_NAME    = "name";
        private static final String COL_DETAILS = "details";
        private static final String COL_ENABLED = "enabled";
    }

    private static final class TireWarrantiesTable {
        private static final String TABLE            = "tire_warranties";
        private static final String COL_ID           = "id";
        private static final String COL_TIRES_ID     = "tires_id";
        private static final String COL_DETAILS      = "details";
        private static final String COL_MAX_TIME     = "max_time";
        private static final String COL_MAX_DIST     = "max_dist";
        private static final String COL_MIN_TRD_DPTH = "min_tread_depth";
        private static final String COL_ENABLED      = "enabled";
        private static final String COL_START_DATE   = "start_date";
        private static final String COL_END_DATE     = "end_date";
    }

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);

        // To be able to see the database in Device Helper/data/database
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        this.createProductsTable( sqLiteDatabase );
        this.createCategoriesTable( sqLiteDatabase );
        this.createProductImagesTable( sqLiteDatabase );
        this.createProductCostsTable( sqLiteDatabase );
        this.createProductSalesPricesTableI( sqLiteDatabase );
        this.createTiresTable( sqLiteDatabase );
        this.createBrandsTable( sqLiteDatabase );
        this.createModelsTable( sqLiteDatabase );
        this.createTireWarrantiesTable( sqLiteDatabase );
    }

    private void createProductsTable( SQLiteDatabase sqLiteDatabase ) {
        sqLiteDatabase.execSQL(
                "create table " + ProductsTable.TABLE + " (" +
                        ProductsTable.COL_ID           + " integer primary key autoincrement, " +
                        ProductsTable.COL_PRODUCT_ID   + " integer, "  +
                        ProductsTable.COL_CAT_ID       + " integer, "  +
                        ProductsTable.COL_QTY_PER_UNIT + " text, "  +
                        ProductsTable.COL_LATEST_COST  + " integer, "  +
                        ProductsTable.COL_LATEST_PRICE + " integer, "  +
                        ProductsTable.COL_ENABLED      + " integer" +
                        ")"
        );
    }

    private void createCategoriesTable( SQLiteDatabase sqLiteDatabase ) {
        sqLiteDatabase.execSQL(
                "create table " + CategoriesTable.TABLE + " (" +
                        CategoriesTable.COL_ID       + " integer primary key autoincrement, " +
                        CategoriesTable.COL_CATEGORY + " text, "  +
                        CategoriesTable.COL_DETAILS  + " text, "  +
                        CategoriesTable.COL_ENABLED  + " integer" +
                        ")"
        );
    }

    private void createProductImagesTable( SQLiteDatabase sqLiteDatabase ) {
        sqLiteDatabase.execSQL(
                "create table " + ProductImagesTable.TABLE + " (" +
                        ProductImagesTable.COL_ID          + " integer primary key autoincrement, " +
                        ProductImagesTable.COL_PRODUCTS_ID + " integer, "  +
                        ProductImagesTable.COL_NAME        + " text, "  +
                        ProductImagesTable.COL_DESC        + " text" +
                        ")"
        );
    }

    private void createProductCostsTable( SQLiteDatabase sqLiteDatabase ) {
        sqLiteDatabase.execSQL(
                "create table " + ProductCostsTable.TABLE + " (" +
                        ProductCostsTable.COL_ID        + " integer primary key autoincrement, " +
                        ProductCostsTable.COL_PROD_ID   + " integer, "  +
                        ProductCostsTable.COL_COST      + " text, "  +
                        ProductCostsTable.COL_FROM_DATE + " text, " +
                        ProductCostsTable.COL_TO_DATE   + " text" +
                        ")"
        );
    }

    private void createProductSalesPricesTableI( SQLiteDatabase sqLiteDatabase ) {
        sqLiteDatabase.execSQL(
                "create table " + ProductSalesPricesTable.TABLE + " (" +
                        ProductSalesPricesTable.COL_ID      + " integer primary key autoincrement, " +
                        ProductSalesPricesTable.COL_PROD_ID + " integer, "  +
                        ProductSalesPricesTable.COL_PRICE   + " text, "  +
                        ProductSalesPricesTable.COL_MSRP    + " text, " +
                        ProductSalesPricesTable.COL_FROM_DATE     + " text, " +
                        ProductSalesPricesTable.COL_TO_DATE       + " text" +
                        ")"
        );
    }

    private void createTiresTable( SQLiteDatabase sqLiteDatabase ) {
        sqLiteDatabase.execSQL(
                "create table " + TiresTable.TABLE  + " (" +
                        TiresTable.COL_ID           + " integer primary key autoincrement, " +
                        TiresTable.PART_NUM         + " text, "    +
                        TiresTable.COL_BRAND_ID     + " integer, " +
                        TiresTable.COL_MODEL_ID     + " integer, " +
                        TiresTable.COL_WIDTH        + " text, "    +
                        TiresTable.COL_ASPECT_RATIO + " text, "    +
                        TiresTable.COL_RIM_DIAM     + " text, "    +
                        TiresTable.COL_CONSTR       + " text, "    +
                        TiresTable.COL_MAX_LOAD     + " text, "    +
                        TiresTable.COL_MAX_PSI      + " text, "    +
                        TiresTable.COL_PLY          + " text, "    +
                        TiresTable.COL_LOAD_RT      + " text, "    +
                        TiresTable.COL_SPEED_RT     + " text, "    +
                        TiresTable.COL_IS_DOT_APPR  + " integer, " +
                        TiresTable.COL_WEIGHT       + " text, "    +
                        TiresTable.COL_HAS_WARRANTY + " integer, " +
                        TiresTable.COL_IS_DISCO     + " integer, " +
                        TiresTable.COL_CREATED_DATE + " text, "    +
                        TiresTable.COL_REMOVED_DATE + " text"      +
                        ")"
        );
    }

    private void createBrandsTable( SQLiteDatabase sqLiteDatabase ) {
        sqLiteDatabase.execSQL(
                "create table " + BrandsTable.TABLE + " (" +
                        BrandsTable.COL_ID      + " integer primary key autoincrement, " +
                        BrandsTable.COL_NAME    + " text, "  +
                        BrandsTable.COL_DETAILS + " text, "  +
                        BrandsTable.COL_ENABLED + " integer" +
                        ")"
        );
    }

    private void createModelsTable( SQLiteDatabase sqLiteDatabase ) {
        sqLiteDatabase.execSQL(
                "create table " + ModelsTable.TABLE + " (" +
                        ModelsTable.COL_ID      + " integer primary key autoincrement, " +
                        ModelsTable.COL_NAME    + " text, "  +
                        ModelsTable.COL_DETAILS + " text, "  +
                        ModelsTable.COL_ENABLED + " integer" +
                        ")"
        );
    }

    private void createTireWarrantiesTable( SQLiteDatabase sqLiteDatabase ) {
        sqLiteDatabase.execSQL(
                "create table " + TireWarrantiesTable.TABLE + " (" +
                        TireWarrantiesTable.COL_ID           + " integer primary key autoincrement, " +
                        TireWarrantiesTable.COL_TIRES_ID     + " integer, " +
                        TireWarrantiesTable.COL_DETAILS      + " text, "    +
                        TireWarrantiesTable.COL_MAX_TIME     + " text, "    +
                        TireWarrantiesTable.COL_MAX_DIST     + " text, "    +
                        TireWarrantiesTable.COL_MIN_TRD_DPTH + " text, "    +
                        TireWarrantiesTable.COL_ENABLED      + " integer, " +
                        TireWarrantiesTable.COL_START_DATE   + " text, "    +
                        TireWarrantiesTable.COL_END_DATE     + " text"      +
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

    // todo insert( Tire tire ) - inserts the tire object into the database
    public void insert(Tire tire) {

    }

    // todo getBrands() - return String[] brands from brands table
    // todo getModels() - return String[] models from models table
    // todo getProducts( String searchParam ) - return list of products that match the search param
    //      + searchParam will be something like 245/45R20:
    //      + 245 = section_width | 45 = aspect_ratio | R = construction | 20 = wheel_diameter
    // todo deleteProduct( int product_id ) - deletes the product from the database. Just set enabled = 0
    // todo modifyProduct( Tire tire, int id ) - modify product details with the specific id
}
