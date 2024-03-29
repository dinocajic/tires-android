package edu.gsu.student.csc4360;

public class PopulateItems {

    public static void populate() {
        String[] brands = {"BFGoodrich", "Continental", "Cooper", "Delinte", "Dunlop", "Falken",
                "Firestone", "Michelin", "Mickey Thompson", "Toyo"};

        String[] mickey_thompson_models = {"Baja Boss", "Baja ATZ P3", "Baja MTZ P3", "Deegan 38",
                "Deegan 38 AT", "Baja Claw", "Baja Claw TTC"};

        // Brand, Model, Part Number, Width, Aspect Ratio, Internal Construction, Wheel Diameter
        // Max Load, Max PSI, Ply, Load Rating, Speed Rating, Weight, Cost, Sales Price, Qty Per Unit
        // Has Warranty, Is DOT Approved, Is Discontinued, Image
        Tire[] tires = new Tire[23];

        tires[0] = new Tire();
        tires[0].setBrand(           Globals.db.getBrand( brands[0] ) );
        tires[0].setModel(           Globals.db.getModel( mickey_thompson_models[0] ) );
        tires[0].setPart_number(     "90000033652" );
        tires[0].setWidth(           "245" );
        tires[0].setAspect_ratio(    "35" );
        tires[0].setConstruction(    "R" );
        tires[0].setWheel_diameter(  "20" );
        tires[0].setMax_load(        "1700" );
        tires[0].setMax_psi(         "35" );
        tires[0].setPly(             "4" );
        tires[0].setLoad_rating(     "E" );
        tires[0].setSpeed_rating(    "Y" );
        tires[0].setWeight(          "50" );
        tires[0].setCost(            "150" );
        tires[0].setSales_price(     "185" );
        tires[0].setQty_per_unit(    "1" );
        tires[0].setHas_warranty(    true );
        tires[0].setIs_dot_approved( true );
        tires[0].setIs_discontinued( false );
        tires[0].setImage( "https://mickeythompsontires.com/thumbs/light-truck-tires/baja-atz-p3/mt-baja-atz-p3-3q-3q-lf-300dpi-shadow-clipped-700x700-q70.png" );

        tires[1] = new Tire();
        tires[1].setBrand(           Globals.db.getBrand( brands[1] ) );
        tires[1].setModel(           Globals.db.getModel( mickey_thompson_models[1] ) );
        tires[1].setPart_number(     "90000035422" );
        tires[1].setWidth(           "245" );
        tires[1].setAspect_ratio(    "35" );
        tires[1].setConstruction(    "R" );
        tires[1].setWheel_diameter(  "20" );
        tires[1].setMax_load(        "1700" );
        tires[1].setMax_psi(         "35" );
        tires[1].setPly(             "4" );
        tires[1].setLoad_rating(     "E" );
        tires[1].setSpeed_rating(    "Y" );
        tires[1].setWeight(          "50" );
        tires[1].setCost(            "150" );
        tires[1].setSales_price(     "185" );
        tires[1].setQty_per_unit(    "1" );
        tires[1].setHas_warranty(    true );
        tires[1].setIs_dot_approved( true );
        tires[1].setIs_discontinued( false );
        tires[1].setImage( "https://mickeythompsontires.com/thumbs/light-truck-tires/baja-mtz-p3/mt-baja-mtzp3-3q-lf-300dpi-shadow-clipped-700x700-q70.png" );

        tires[2] = new Tire();
        tires[2].setBrand(           Globals.db.getBrand( brands[2] ) );
        tires[2].setModel(           Globals.db.getModel( mickey_thompson_models[2] ) );
        tires[2].setPart_number(     "90000045352" );
        tires[2].setWidth(           "245" );
        tires[2].setAspect_ratio(    "35" );
        tires[2].setConstruction(    "R" );
        tires[2].setWheel_diameter(  "20" );
        tires[2].setMax_load(        "1700" );
        tires[2].setMax_psi(         "35" );
        tires[2].setPly(             "4" );
        tires[2].setLoad_rating(     "E" );
        tires[2].setSpeed_rating(    "Y" );
        tires[2].setWeight(          "50" );
        tires[2].setCost(            "150" );
        tires[2].setSales_price(     "185" );
        tires[2].setQty_per_unit(    "1" );
        tires[2].setHas_warranty(    true );
        tires[2].setIs_dot_approved( true );
        tires[2].setIs_discontinued( false );
        tires[2].setImage( "https://mickeythompsontires.com/thumbs/light-truck-tires/deegan-38-all-terrain/mt-deegan-all-terrain-3q-lf-300dpi-shadow-clipped-700x700-q70.png" );

        tires[3] = new Tire();
        tires[3].setBrand(           Globals.db.getBrand( brands[3] ) );
        tires[3].setModel(           Globals.db.getModel( mickey_thompson_models[3] ) );
        tires[3].setPart_number(     "90000063612" );
        tires[3].setWidth(           "245" );
        tires[3].setAspect_ratio(    "35" );
        tires[3].setConstruction(    "R" );
        tires[3].setWheel_diameter(  "20" );
        tires[3].setMax_load(        "1700" );
        tires[3].setMax_psi(         "35" );
        tires[3].setPly(             "4" );
        tires[3].setLoad_rating(     "E" );
        tires[3].setSpeed_rating(    "Y" );
        tires[3].setWeight(          "50" );
        tires[3].setCost(            "150" );
        tires[3].setSales_price(     "185" );
        tires[3].setQty_per_unit(    "1" );
        tires[3].setHas_warranty(    true );
        tires[3].setIs_dot_approved( true );
        tires[3].setIs_discontinued( false );
        tires[3].setImage( "https://mickeythompsontires.com/thumbs/light-truck-tires/deegan-38/mt-deegan-mud-3q-lf-300dpi-shadow-clipped-2-700x700-q70.png" );

        tires[4] = new Tire();
        tires[4].setBrand(           Globals.db.getBrand( brands[4] ) );
        tires[4].setModel(           Globals.db.getModel( mickey_thompson_models[4] ) );
        tires[4].setPart_number(     "90000014678" );
        tires[4].setWidth(           "245" );
        tires[4].setAspect_ratio(    "35" );
        tires[4].setConstruction(    "R" );
        tires[4].setWheel_diameter(  "20" );
        tires[4].setMax_load(        "1700" );
        tires[4].setMax_psi(         "35" );
        tires[4].setPly(             "4" );
        tires[4].setLoad_rating(     "E" );
        tires[4].setSpeed_rating(    "Y" );
        tires[4].setWeight(          "50" );
        tires[4].setCost(            "150" );
        tires[4].setSales_price(     "185" );
        tires[4].setQty_per_unit(    "1" );
        tires[4].setHas_warranty(    true );
        tires[4].setIs_dot_approved( true );
        tires[4].setIs_discontinued( false );
        tires[4].setImage( "https://mickeythompsontires.com/thumbs/light-truck-tires/baja-claw-46/mt-baja-claw-46-3q-lf-300dpi-shadow-clipped-700x700-q70.png" );

        tires[5] = new Tire();
        tires[5].setBrand(           Globals.db.getBrand( brands[5] ) );
        tires[5].setModel(           Globals.db.getModel( mickey_thompson_models[5] ) );
        tires[5].setPart_number(     "90000011345" );
        tires[5].setWidth(           "255" );
        tires[5].setAspect_ratio(    "55" );
        tires[5].setConstruction(    "R" );
        tires[5].setWheel_diameter(  "20" );
        tires[5].setMax_load(        "1700" );
        tires[5].setMax_psi(         "35" );
        tires[5].setPly(             "4" );
        tires[5].setLoad_rating(     "E" );
        tires[5].setSpeed_rating(    "Y" );
        tires[5].setWeight(          "50" );
        tires[5].setCost(            "150" );
        tires[5].setSales_price(     "185" );
        tires[5].setQty_per_unit(    "1" );
        tires[5].setHas_warranty(    true );
        tires[5].setIs_dot_approved( true );
        tires[5].setIs_discontinued( false );
        tires[5].setImage( "https://mickeythompsontires.com/thumbs/light-truck-tires/baja-claw-ttc-radial/mt-baja-claw-ttc-3q-lf-300dpi-shadow-clipped-700x700-q70.png" );

        tires[6] = new Tire();
        tires[6].setBrand(           Globals.db.getBrand( brands[6] ) );
        tires[6].setModel(           Globals.db.getModel( mickey_thompson_models[6] ) );
        tires[6].setPart_number(     "90000075434" );
        tires[6].setWidth(           "255" );
        tires[6].setAspect_ratio(    "55" );
        tires[6].setConstruction(    "R" );
        tires[6].setWheel_diameter(  "20" );
        tires[6].setMax_load(        "1700" );
        tires[6].setMax_psi(         "35" );
        tires[6].setPly(             "4" );
        tires[6].setLoad_rating(     "E" );
        tires[6].setSpeed_rating(    "Y" );
        tires[6].setWeight(          "50" );
        tires[6].setCost(            "150" );
        tires[6].setSales_price(     "185" );
        tires[6].setQty_per_unit(    "1" );
        tires[6].setHas_warranty(    true );
        tires[6].setIs_dot_approved( true );
        tires[6].setIs_discontinued( false );
        tires[6].setImage( "https://mickeythompsontires.com/thumbs/light-truck-tires/baja-pro-radial/mt-baja-pro-radial-3q-lf-300dpi-shadow-clipped-700x700-q70.png" );

        tires[7] = new Tire();
        tires[7].setBrand(           Globals.db.getBrand( brands[7] ) );
        tires[7].setModel(           Globals.db.getModel( mickey_thompson_models[0] ) );
        tires[7].setPart_number(     "90000012675" );
        tires[7].setWidth(           "255" );
        tires[7].setAspect_ratio(    "35" );
        tires[7].setConstruction(    "R" );
        tires[7].setWheel_diameter(  "20" );
        tires[7].setMax_load(        "1700" );
        tires[7].setMax_psi(         "35" );
        tires[7].setPly(             "4" );
        tires[7].setLoad_rating(     "E" );
        tires[7].setSpeed_rating(    "Y" );
        tires[7].setWeight(          "50" );
        tires[7].setCost(            "150" );
        tires[7].setSales_price(     "185" );
        tires[7].setQty_per_unit(    "1" );
        tires[7].setHas_warranty(    true );
        tires[7].setIs_dot_approved( true );
        tires[7].setIs_discontinued( false );
        tires[7].setImage( "https://mickeythompsontires.com/thumbs/light-truck-tires/baja-pro-x/baja-pro-x-3q-700x700-q70.png" );

        tires[8] = new Tire();
        tires[8].setBrand(           Globals.db.getBrand( brands[8] ) );
        tires[8].setModel(           Globals.db.getModel( mickey_thompson_models[1] ) );
        tires[8].setPart_number(     "90000036543" );
        tires[8].setWidth(           "255" );
        tires[8].setAspect_ratio(    "35" );
        tires[8].setConstruction(    "R" );
        tires[8].setWheel_diameter(  "20" );
        tires[8].setMax_load(        "1700" );
        tires[8].setMax_psi(         "35" );
        tires[8].setPly(             "4" );
        tires[8].setLoad_rating(     "E" );
        tires[8].setSpeed_rating(    "Y" );
        tires[8].setWeight(          "50" );
        tires[8].setCost(            "150" );
        tires[8].setSales_price(     "185" );
        tires[8].setQty_per_unit(    "1" );
        tires[8].setHas_warranty(    true );
        tires[8].setIs_dot_approved( true );
        tires[8].setIs_discontinued( false );
        tires[8].setImage( "https://mickeythompsontires.com/thumbs/light-truck-tires/baja-claw-46/mt-baja-claw-46-3q-lf-300dpi-shadow-clipped-700x700-q70.png" );

        tires[9] = new Tire();
        tires[9].setBrand(           Globals.db.getBrand( brands[9] ) );
        tires[9].setModel(           Globals.db.getModel( mickey_thompson_models[2] ) );
        tires[9].setPart_number(     "90000062854" );
        tires[9].setWidth(           "255" );
        tires[9].setAspect_ratio(    "35" );
        tires[9].setConstruction(    "R" );
        tires[9].setWheel_diameter(  "20" );
        tires[9].setMax_load(        "1700" );
        tires[9].setMax_psi(         "35" );
        tires[9].setPly(             "4" );
        tires[9].setLoad_rating(     "E" );
        tires[9].setSpeed_rating(    "Y" );
        tires[9].setWeight(          "50" );
        tires[9].setCost(            "150" );
        tires[9].setSales_price(     "185" );
        tires[9].setQty_per_unit(    "1" );
        tires[9].setHas_warranty(    true );
        tires[9].setIs_dot_approved( true );
        tires[9].setIs_discontinued( false );
        tires[9].setImage( "https://mickeythompsontires.com/thumbs/light-truck-tires/mini-mag/minimag-700x700-q70.png" );

        tires[10] = new Tire();
        tires[10].setBrand(           Globals.db.getBrand( brands[0] ) );
        tires[10].setModel(           Globals.db.getModel( mickey_thompson_models[3] ) );
        tires[10].setPart_number(     "90000029998" );
        tires[10].setWidth(           "255" );
        tires[10].setAspect_ratio(    "35" );
        tires[10].setConstruction(    "R" );
        tires[10].setWheel_diameter(  "20" );
        tires[10].setMax_load(        "1700" );
        tires[10].setMax_psi(         "35" );
        tires[10].setPly(             "4" );
        tires[10].setLoad_rating(     "E" );
        tires[10].setSpeed_rating(    "Y" );
        tires[10].setWeight(          "50" );
        tires[10].setCost(            "150" );
        tires[10].setSales_price(     "185" );
        tires[10].setQty_per_unit(    "1" );
        tires[10].setHas_warranty(    true );
        tires[10].setIs_dot_approved( true );
        tires[10].setIs_discontinued( false );
        tires[10].setImage( "https://mickeythompsontires.com/thumbs/street-tires/street-comp/mt-street-comp-3q-lf-300dpi-shadow-clipped-700x700-q70.png" );

        tires[11] = new Tire();
        tires[11].setBrand(           Globals.db.getBrand( brands[1] ) );
        tires[11].setModel(           Globals.db.getModel( mickey_thompson_models[4] ) );
        tires[11].setPart_number(     "90000087933" );
        tires[11].setWidth(           "255" );
        tires[11].setAspect_ratio(    "55" );
        tires[11].setConstruction(    "R" );
        tires[11].setWheel_diameter(  "22" );
        tires[11].setMax_load(        "1700" );
        tires[11].setMax_psi(         "35" );
        tires[11].setPly(             "4" );
        tires[11].setLoad_rating(     "E" );
        tires[11].setSpeed_rating(    "Y" );
        tires[11].setWeight(          "50" );
        tires[11].setCost(            "150" );
        tires[11].setSales_price(     "185" );
        tires[11].setQty_per_unit(    "1" );
        tires[11].setHas_warranty(    true );
        tires[11].setIs_dot_approved( true );
        tires[11].setIs_discontinued( false );
        tires[11].setImage( "https://mickeythompsontires.com/thumbs/street-tires/sportsman-s-t/mt-sportsman-st-3q-lf-300dpi-shadow-clipped-700x700-q70.png" );

        tires[12] = new Tire();
        tires[12].setBrand(           Globals.db.getBrand( brands[2] ) );
        tires[12].setModel(           Globals.db.getModel( mickey_thompson_models[5] ) );
        tires[12].setPart_number(     "90000046754" );
        tires[12].setWidth(           "265" );
        tires[12].setAspect_ratio(    "55" );
        tires[12].setConstruction(    "R" );
        tires[12].setWheel_diameter(  "20" );
        tires[12].setMax_load(        "1700" );
        tires[12].setMax_psi(         "35" );
        tires[12].setPly(             "4" );
        tires[12].setLoad_rating(     "E" );
        tires[12].setSpeed_rating(    "Y" );
        tires[12].setWeight(          "50" );
        tires[12].setCost(            "150" );
        tires[12].setSales_price(     "185" );
        tires[12].setQty_per_unit(    "1" );
        tires[12].setHas_warranty(    true );
        tires[12].setIs_dot_approved( true );
        tires[12].setIs_discontinued( false );
        tires[12].setImage( "https://mickeythompsontires.com/thumbs/street-tires/sportsman-front/mt-sportsman-front-3q-lf-300dpi-shadow-clipped-700x700-q70.png" );

        tires[13] = new Tire();
        tires[13].setBrand(           Globals.db.getBrand( brands[3] ) );
        tires[13].setModel(           Globals.db.getModel( mickey_thompson_models[6] ) );
        tires[13].setPart_number(     "90000055768" );
        tires[13].setWidth(           "265" );
        tires[13].setAspect_ratio(    "55" );
        tires[13].setConstruction(    "R" );
        tires[13].setWheel_diameter(  "20" );
        tires[13].setMax_load(        "1700" );
        tires[13].setMax_psi(         "35" );
        tires[13].setPly(             "4" );
        tires[13].setLoad_rating(     "E" );
        tires[13].setSpeed_rating(    "Y" );
        tires[13].setWeight(          "50" );
        tires[13].setCost(            "150" );
        tires[13].setSales_price(     "185" );
        tires[13].setQty_per_unit(    "1" );
        tires[13].setHas_warranty(    true );
        tires[13].setIs_dot_approved( true );
        tires[13].setIs_discontinued( false );
        tires[13].setImage( "https://mickeythompsontires.com/thumbs/street-tires/sportsman-pro/mt-sportsman-pro-3q-lf-300dpi-shadow-clipped-700x700-q70.png" );

        tires[14] = new Tire();
        tires[14].setBrand(           Globals.db.getBrand( brands[4] ) );
        tires[14].setModel(           Globals.db.getModel( mickey_thompson_models[0] ) );
        tires[14].setPart_number(     "90000001365" );
        tires[14].setWidth(           "265" );
        tires[14].setAspect_ratio(    "55" );
        tires[14].setConstruction(    "R" );
        tires[14].setWheel_diameter(  "20" );
        tires[14].setMax_load(        "1700" );
        tires[14].setMax_psi(         "35" );
        tires[14].setPly(             "4" );
        tires[14].setLoad_rating(     "E" );
        tires[14].setSpeed_rating(    "Y" );
        tires[14].setWeight(          "50" );
        tires[14].setCost(            "150" );
        tires[14].setSales_price(     "185" );
        tires[14].setQty_per_unit(    "1" );
        tires[14].setHas_warranty(    true );
        tires[14].setIs_dot_approved( true );
        tires[14].setIs_discontinued( false );
        tires[14].setImage( "https://mickeythompsontires.com/thumbs/drag-tires/et-drag/mt-et-drag-5inch-3q-lf-700x700-q70.png" );

        tires[15] = new Tire();
        tires[15].setBrand(           Globals.db.getBrand( brands[5] ) );
        tires[15].setModel(           Globals.db.getModel( mickey_thompson_models[1] ) );
        tires[15].setPart_number(     "90000077324" );
        tires[15].setWidth(           "275" );
        tires[15].setAspect_ratio(    "35" );
        tires[15].setConstruction(    "R" );
        tires[15].setWheel_diameter(  "20" );
        tires[15].setMax_load(        "1700" );
        tires[15].setMax_psi(         "35" );
        tires[15].setPly(             "4" );
        tires[15].setLoad_rating(     "E" );
        tires[15].setSpeed_rating(    "Y" );
        tires[15].setWeight(          "50" );
        tires[15].setCost(            "150" );
        tires[15].setSales_price(     "185" );
        tires[15].setQty_per_unit(    "1" );
        tires[15].setHas_warranty(    true );
        tires[15].setIs_dot_approved( true );
        tires[15].setIs_discontinued( false );
        tires[15].setImage( "https://mickeythompsontires.com/thumbs/drag-tires/et-drag-radial/mt-et-drag-pro-radial-3q-lf-300dpi-shadow-clipped_preview-700x700-q70.png" );

        tires[16] = new Tire();
        tires[16].setBrand(           Globals.db.getBrand( brands[6] ) );
        tires[16].setModel(           Globals.db.getModel( mickey_thompson_models[2] ) );
        tires[16].setPart_number(     "90000088971" );
        tires[16].setWidth(           "275" );
        tires[16].setAspect_ratio(    "35" );
        tires[16].setConstruction(    "R" );
        tires[16].setWheel_diameter(  "20" );
        tires[16].setMax_load(        "1700" );
        tires[16].setMax_psi(         "35" );
        tires[16].setPly(             "4" );
        tires[16].setLoad_rating(     "E" );
        tires[16].setSpeed_rating(    "Y" );
        tires[16].setWeight(          "50" );
        tires[16].setCost(            "150" );
        tires[16].setSales_price(     "185" );
        tires[16].setQty_per_unit(    "1" );
        tires[16].setHas_warranty(    true );
        tires[16].setIs_dot_approved( true );
        tires[16].setIs_discontinued( false );
        tires[16].setImage( "https://mickeythompsontires.com/thumbs/drag-tires/pro-bracket-radial/mt-pro-bracket-radial-3q-lf-300dpi-shadow-clipped_preview-700x700-q70.png" );

        tires[17] = new Tire();
        tires[17].setBrand(           Globals.db.getBrand( brands[7] ) );
        tires[17].setModel(           Globals.db.getModel( mickey_thompson_models[3] ) );
        tires[17].setPart_number(     "90000025345" );
        tires[17].setWidth(           "275" );
        tires[17].setAspect_ratio(    "35" );
        tires[17].setConstruction(    "R" );
        tires[17].setWheel_diameter(  "20" );
        tires[17].setMax_load(        "1700" );
        tires[17].setMax_psi(         "35" );
        tires[17].setPly(             "4" );
        tires[17].setLoad_rating(     "E" );
        tires[17].setSpeed_rating(    "Y" );
        tires[17].setWeight(          "50" );
        tires[17].setCost(            "150" );
        tires[17].setSales_price(     "185" );
        tires[17].setQty_per_unit(    "1" );
        tires[17].setHas_warranty(    true );
        tires[17].setIs_dot_approved( true );
        tires[17].setIs_discontinued( false );
        tires[17].setImage( "https://mickeythompsontires.com/thumbs/drag-tires/et-street-r/mt-et-street-r-3q-lf-1024-700x700-q70.png" );

        tires[18] = new Tire();
        tires[18].setBrand(           Globals.db.getBrand( brands[8] ) );
        tires[18].setModel(           Globals.db.getModel( mickey_thompson_models[4] ) );
        tires[18].setPart_number(     "90000035543" );
        tires[18].setWidth(           "275" );
        tires[18].setAspect_ratio(    "35" );
        tires[18].setConstruction(    "R" );
        tires[18].setWheel_diameter(  "20" );
        tires[18].setMax_load(        "1700" );
        tires[18].setMax_psi(         "35" );
        tires[18].setPly(             "4" );
        tires[18].setLoad_rating(     "E" );
        tires[18].setSpeed_rating(    "Y" );
        tires[18].setWeight(          "50" );
        tires[18].setCost(            "150" );
        tires[18].setSales_price(     "185" );
        tires[18].setQty_per_unit(    "1" );
        tires[18].setHas_warranty(    true );
        tires[18].setIs_dot_approved( true );
        tires[18].setIs_discontinued( false );
        tires[18].setImage( "https://mickeythompsontires.com/thumbs/drag-tires/et-street-r-bias/mt-et-street-r-bias-3q-lf-300dpi-shadow-clipped-700x700-q70.png" );

        tires[19] = new Tire();
        tires[19].setBrand(           Globals.db.getBrand( brands[9] ) );
        tires[19].setModel(           Globals.db.getModel( mickey_thompson_models[5] ) );
        tires[19].setPart_number(     "90000095464" );
        tires[19].setWidth(           "305" );
        tires[19].setAspect_ratio(    "35" );
        tires[19].setConstruction(    "R" );
        tires[19].setWheel_diameter(  "20" );
        tires[19].setMax_load(        "1700" );
        tires[19].setMax_psi(         "35" );
        tires[19].setPly(             "4" );
        tires[19].setLoad_rating(     "E" );
        tires[19].setSpeed_rating(    "Y" );
        tires[19].setWeight(          "50" );
        tires[19].setCost(            "150" );
        tires[19].setSales_price(     "185" );
        tires[19].setQty_per_unit(    "1" );
        tires[19].setHas_warranty(    true );
        tires[19].setIs_dot_approved( true );
        tires[19].setIs_discontinued( false );
        tires[19].setImage( "https://mickeythompsontires.com/thumbs/drag-tires/et-street-s-s/mt-street-ss-3q-lf-300dpi-shadow-clipped-700x700-q70.png" );

        tires[20] = new Tire();
        tires[20].setBrand(           Globals.db.getBrand( brands[0] ) );
        tires[20].setModel(           Globals.db.getModel( mickey_thompson_models[6] ) );
        tires[20].setPart_number(     "90000022114" );
        tires[20].setWidth(           "305" );
        tires[20].setAspect_ratio(    "35" );
        tires[20].setConstruction(    "R" );
        tires[20].setWheel_diameter(  "20" );
        tires[20].setMax_load(        "1700" );
        tires[20].setMax_psi(         "35" );
        tires[20].setPly(             "4" );
        tires[20].setLoad_rating(     "E" );
        tires[20].setSpeed_rating(    "Y" );
        tires[20].setWeight(          "50" );
        tires[20].setCost(            "150" );
        tires[20].setSales_price(     "185" );
        tires[20].setQty_per_unit(    "1" );
        tires[20].setHas_warranty(    true );
        tires[20].setIs_dot_approved( true );
        tires[20].setIs_discontinued( false );
        tires[20].setImage( "https://mickeythompsontires.com/thumbs/drag-tires/et-street-radial-pro/mt-et-street-radial-pro-3q-lf-300dpi-shadow-clipped-700x700-q70.png" );

        tires[21] = new Tire();
        tires[21].setBrand(           Globals.db.getBrand( brands[1] ) );
        tires[21].setModel(           Globals.db.getModel( mickey_thompson_models[0] ) );
        tires[21].setPart_number(     "90000066443" );
        tires[21].setWidth(           "315" );
        tires[21].setAspect_ratio(    "35" );
        tires[21].setConstruction(    "R" );
        tires[21].setWheel_diameter(  "20" );
        tires[21].setMax_load(        "1700" );
        tires[21].setMax_psi(         "35" );
        tires[21].setPly(             "4" );
        tires[21].setLoad_rating(     "E" );
        tires[21].setSpeed_rating(    "Y" );
        tires[21].setWeight(          "50" );
        tires[21].setCost(            "150" );
        tires[21].setSales_price(     "185" );
        tires[21].setQty_per_unit(    "1" );
        tires[21].setHas_warranty(    true );
        tires[21].setIs_dot_approved( true );
        tires[21].setIs_discontinued( false );
        tires[21].setImage( "https://mickeythompsontires.com/thumbs/drag-tires/et-jr/mt-et-jr-3q-lf-1024-300dpi-shadow-clipped-700x700-q70.png" );

        tires[22] = new Tire();
        tires[22].setBrand(           Globals.db.getBrand( brands[2] ) );
        tires[22].setModel(           Globals.db.getModel( mickey_thompson_models[1] ) );
        tires[22].setPart_number(     "90000014678" );
        tires[22].setWidth(           "315" );
        tires[22].setAspect_ratio(    "35" );
        tires[22].setConstruction(    "R" );
        tires[22].setWheel_diameter(  "20" );
        tires[22].setMax_load(        "1700" );
        tires[22].setMax_psi(         "35" );
        tires[22].setPly(             "4" );
        tires[22].setLoad_rating(     "E" );
        tires[22].setSpeed_rating(    "Y" );
        tires[22].setWeight(          "50" );
        tires[22].setCost(            "150" );
        tires[22].setSales_price(     "185" );
        tires[22].setQty_per_unit(    "1" );
        tires[22].setHas_warranty(    true );
        tires[22].setIs_dot_approved( true );
        tires[22].setIs_discontinued( false );
        tires[22].setImage( "https://mickeythompsontires.com/thumbs/street-tires/sportsman-pro/mt-sportsman-pro-3q-lf-300dpi-shadow-clipped-700x700-q70.png" );

        for ( Tire tire : tires ) {
            Globals.db.insert( tire );
        }
    }
}
