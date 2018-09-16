package com.example.xaulleon.credipool;



import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class WebServiceInsertCard extends AsyncTask<Void, Void, Boolean> {
    String mesg;
    String cardNum = null;
    String expDate = null;
    String cvv = null;

    String network=null;

    public WebServiceInsertCard(String cardNum, String cvv, String network, String expDate) {
        this.cardNum=cardNum;
        this.cvv=cvv;
        this.network=network;
        this.expDate=expDate;
    }


    @Override
    protected Boolean doInBackground(Void... voids) {


        final String NAMESPACE = "http://ws_joao/";
        final String URL="http://node39345-creditpool.jl.serv.net.mx/StarWarsOZoombies?wsdl";

        final String METHOD_NAME = "InsertCreditCard";
        final String SOAP_ACTION = "http://ws_joao/InsertCreditCard";


        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

        request.addProperty("id_client", 1);
        request.addProperty("credit_card", cardNum);
        request.addProperty("ccv", cvv);
        request.addProperty("exp_date", expDate);
        request.addProperty("network", network);


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
