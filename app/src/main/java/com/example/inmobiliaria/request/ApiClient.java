package com.example.inmobiliaria.request;

import android.content.Context;
import android.content.SharedPreferences;
import android.telecom.Call;
import android.util.Log;

import com.example.inmobiliaria.modelo.Contratos;
import com.example.inmobiliaria.modelo.Inmuebles;
import com.example.inmobiliaria.modelo.Inquilinos;
import com.example.inmobiliaria.modelo.LoginView;
import com.example.inmobiliaria.modelo.Pagos;
import com.example.inmobiliaria.modelo.Propietarios;

import java.util.ArrayList;
import java.util.List;

public class ApiClient {

    private ArrayList<Propietarios> propietarios=new ArrayList<>();
    private ArrayList<Inquilinos> inquilinos=new ArrayList<>();
    private ArrayList<Inmuebles> inmuebles=new ArrayList<>();
    private ArrayList<Contratos> contratos=new ArrayList<>();
    private ArrayList<Pagos> pagos=new ArrayList<>();
    private static Propietarios usuarioActual=null;
    private static ApiClient api=null;

    private ApiClient(){
        //Nos conectamos a nuestra "Base de Datos"
        cargaDatos();
    }
    //Método para crear una instancia de ApiClient
    public static ApiClient getApi(){
        if (api==null){
            api=new ApiClient();
        }
        return api;

    }




    //Servicios
    //Para que pueda iniciar sesion
    public Propietarios login(String mail, final String clave){
        for(Propietarios propietario:propietarios){
            if(propietario.getEmail().equals(mail)&&propietario.getClave().equals(clave)){
                usuarioActual=propietario;
                return propietario;
            }
        }
        return null;
    }


    //Retorna el usuario que inició Sesión
    public Propietarios obtenerUsuarioActual(){
        return usuarioActual;
    }


    //Retorna las propiedades del usuario propietario logueado
    public ArrayList<Inmuebles> obtnerPropiedades(){
        ArrayList<Inmuebles> temp=new ArrayList<>();
        for(Inmuebles inmueble:inmuebles){
            if(inmueble.getPropietarios().equals(usuarioActual)){
                temp.add(inmueble);
            }
        }
        return temp;
    }

    //Lista de inmuebles con contratos vigentes del Propietario logueado
    public ArrayList<Inmuebles> obtenerPropiedadesAlquiladas(){
        ArrayList<Inmuebles> temp=new ArrayList<>();
        for(Contratos contratos:contratos){
            if(contratos.getInmuebles().getPropietarios().equals(usuarioActual)){
                temp.add(contratos.getInmuebles());
            }
        }
        return temp;
    }


//Dado un inmueble retorna el contrato activo de dicho inmueble

    public Contratos obtenerContratoVigente(Inmuebles inmuebles){

        for(Contratos contratos:contratos){
            if(contratos.getInmuebles().equals(inmuebles)){
                return contratos;
            }
        }
        return null;
    }

    //Dado un inmueble, retorna el inquilino del ultimo contrato activo de ese inmueble.
    public Inquilinos obtenerInquilino(Inmuebles inmueble){
        for(Contratos contrato:contratos){
            if(contrato.getInmuebles().equals(inmueble)){
                return contrato.getInquilinos();
            }
        }
        return null;
    }
    //Dado un Contrato, retorna los pagos de dicho contrato
    public ArrayList<Pagos> obtenerPagos(Contratos contratoVer){
        ArrayList<Pagos> temp=new ArrayList<>();
        for(Contratos contratos:contratos){
            if(contratos.equals(contratoVer)){
                for(Pagos pagos:pagos){
                    if(pagos.getContratos().equals(contratos)){
                        temp.add(pagos);
                    }
                }
            }
            break;
        }
        return temp;
    }
    //Actualizar Perfil
    public void actualizarPerfil(Propietarios propietario){
        usuarioActual.setIdProp(propietario.getIdProp());
        usuarioActual.setDni(propietario.getDni());
        usuarioActual.setApellido(propietario.getApellido());
        usuarioActual.setEmail(propietario.getEmail());
        usuarioActual.setClave(propietario.getClave());
        usuarioActual.setTelefono(propietario.getTelefono());
    }

    //ActualizarInmueble
    public void actualizarInmueble(Inmuebles inmuebles){
        int posicion=inmuebles.indexOf(inmuebles);
        if(posicion!=-1){
            inmuebles.set(posicion,inmuebles);
        }
    }

    private void cargaDatos(){

        //Propietarios
        Propietarios noelia=new Propietarios(1,"31276462","Noelia","Antonio","Noelia@mail.com","1234","2665000463");
        Propietarios kevin=new Propietarios(2,"48017769","Kevin","Ferramola","Kevin@mail.com","1234","2664112233");
        propietarios.add(noelia);
        propietarios.add(kevin);

        //Inquilinos
        Inquilinos mario=new Inquilinos(1,31276462,"Luna","Aiello sup.","luna@mail.com","2664253411","Lucero Roberto","2664851422");
        inquilinos.add(mario);

        //Inmuebles
        Inmuebles salon=new Inmuebles(501,"Colon 340","comercial","salon",2,20000,noelia,true,"http://www.secsanluis.com.ar/servicios/salon1.jpg");
        Inmuebles casa=new Inmuebles(502,"Mitre 800","particular","casa",2,15000,kevin,true,"http://www.secsanluis.com.ar/servicios/casa1.jpg");
        Inmuebles otraCasa=new Inmuebles(503,"Salta 325","particular","casa",3,17000,noelia,true,"http://www.secsanluis.com.ar/servicios/casa2.jpg");
        Inmuebles dpto=new Inmuebles(504,"Lavalle 450","particular","dpto",2,25000,kevin,true,"http://www.secsanluis.com.ar/servicios/departamento1.jpg");
        Inmuebles casita=new Inmuebles(505,"Belgrano 218","particular","casa",5,90000,noelia,true,"http://www.secsanluis.com.ar/servicios/casa3.jpg");

        inmuebles.add(salon);
        inmuebles.add(casa);
        inmuebles.add(otraCasa);
        inmuebles.add(dpto);
        inmuebles.add(casita);

        //Contratos
        Contratos uno=new Contratos(701, "05/01/2020","05/01/2021",17000,mario,otraCasa);
        contratos.add(uno);
        //Pagos
        pagos.add(new Pagos(900,1,uno,17000,"10/02/2020"));
        pagos.add(new Pagos(901,2,uno,17000,"10/03/2020"));
        pagos.add(new Pagos(902,3,uno,17000,"10/04/2020"));




    }

    ///////////////////////////////////////////////////////////////////////
    private static final String PATH="http://192.168.0.102:45455/api/";
    private static  MyApiInterface myApiInteface;

    public static MyApiInterface getMyApiClient(){

        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(PATH)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        myApiInteface=retrofit.create(MyApiInterface.class);

        Log.d("salida",retrofit.baseUrl().toString());
        return myApiInteface;
    }

    public interface MyApiInterface {


        //Propietarios
        @POST("Propietarios/login")
        Call<String> login (@Body LoginView loginView);

        @GET("Propietarios")
        Call<Propietarios> propietarioActual (@Header("Authorization") String token);

        @PUT("Propietarios/{id}")
        Call<Propietarios> actualizarPropietario(@Body Propietarios propietarios, @Path("id") int groupId, @Header("Authorization") String token );

        //Inmuebles
        @GET("Inmuebles")
        Call<List<Inmuebles>> listaInmuebles (@Header("Authorization") String token);

        @GET("Inmuebles/obtenerPorId/{id}")
        Call<Inmuebles>obtenerPorId(@Path("id") int id, @Header("Authorization")String token);

        @PUT("Inmuebles/modificarDisponible/{id}")
        Call<Inmuebles>modificarDisponible(@Header("Authorization") String token,@Path("id") int id);

        //Contratos
        @GET("Contratos/inmueblesConContrato")
        Call<List<Contratos>>inmueblesConContrato(@Header("Authorization")String token);

        @GET("Contratos/inmueble/{id}")
        Call<Contratos>obtenerContratoPorId(@Path("id") int id, @Header("Authorization")String token);

        //Inquilinos Actuales
        @GET("Inquilinos")
        Call<List<Contratos>> obtenerInquilinos(@Header("Authorization") String token );

        //Pagos
        @GET("Pago/{id}")
        Call<List<Pagos>> pagosPorcontrato(@Path("id") int id, @Header("Authorization") String token);





    }


    public static String obtenerToken(Context context){

        SharedPreferences sharedPreferences = context.getSharedPreferences("token.dat",0);
        return sharedPreferences.getString("token","Token no encontrado");


    }
}
