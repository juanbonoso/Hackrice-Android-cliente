package com.example.xaulleon.credipool;

import android.os.AsyncTask;
import android.util.Log;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;
import java.util.List;

public class WebServiceGetCards extends AsyncTask<Void, Void, Boolean> {



    public static ArrayList<CardList> cl=new ArrayList<CardList>();
    String[]array;
    @Override
    protected Boolean doInBackground(Void... voids) {


        final String NAMESPACE = "http://ws_joao/";
        final String URL="http://node39345-creditpool.jl.serv.net.mx/StarWarsOZoombies?wsdl";

        final String METHOD_NAME = "yaFue";
        final String SOAP_ACTION = "http://ws_joao/yaFue";


        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

        request.addProperty("id_client", 1);


        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(request);

        HttpTransportSE ht = new HttpTransportSE(URL);
        try {
            ht.call(SOAP_ACTION, envelope);
            SoapPrimitive response = (SoapPrimitive)envelope.getResponse();
            String mesg=response.toString();
            array=mesg.split("@");




        }
        catch (Exception e)
        {
            e.printStackTrace();
            Log.i("Resultado: ",e.toString());

        }




        return null;
    }

    public String[] getArray() {

        for(int i=0;i<array.length;i++)
        {
            Log.i("Resultado",array[i]);
        }
        return array;
    }
}
