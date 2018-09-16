package com.example.xaulleon.credipool;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class WebServiceInsertClient extends AsyncTask<Void, Void, Boolean> {

    String mesg;
    String cardNum = null;
    String expDate = null;
    String cvv = null;
    int option;
    String ssn=null;
    String name=null;
    String last_name=null;
    String address=null;
    String mobile=null;
    String email=null;
    String password=null;
    String network=null;








    @Override
    protected Boolean doInBackground(Void... voids) {
        final String NAMESPACE = "http://ws_joao/";
        final String URL="http://node39345-creditpool.jl.serv.net.mx/StarWarsOZoombies?wsdl";

        final String METHOD_NAME = "InsertClient";
        final String SOAP_ACTION = "http://ws_joao/InsertClient";
        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

        String ssn="092257185";
        String name="Vergao";
        String last_name="Vergao";
        String address="Vergao";
        String mobile="Vergao";
        String email="Vergao1";
        String password="bolsANO";


        request.addProperty("scn", ssn);
        request.addProperty("name", name);
        request.addProperty("last_name", last_name);
        request.addProperty("address", address);
        request.addProperty("mobile", mobile);
        request.addProperty("email", email);
        request.addProperty("password", password);


        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(request);

        HttpTransportSE ht = new HttpTransportSE(URL);
        try {
            ht.call(SOAP_ACTION, envelope);
            SoapPrimitive response = (SoapPrimitive)envelope.getResponse();
            //mesg=response.toString();
            //Log.i("Resultado: ",mesg);

        }
        catch (Exception e)
        {
            e.printStackTrace();
            Log.i("Resultado: ",e.toString());

        }




        return null;
    }



}