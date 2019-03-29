package rodriguezfernandez.carlos.simpleasynctask;

import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask<Void,Void,String> {
    private WeakReference<TextView> mTextView;
    public SimpleAsyncTask(TextView tv){//Constructor.
        mTextView=new WeakReference<>(tv);//Una referencia debil al textview de la Actividad principal.
    }
    @Override
    protected String doInBackground(Void... voids) {
        Random r=new Random();
        int n=r.nextInt(11);
        int s=n*200;
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Activo despues de pausado por "+s+" milisegundos";
    }

    @Override
    protected void onPostExecute(String s) {//En la actividad aparece la variable como result, yo he usado la que me da por defectoel IDE.
        //super.onPostExecute(s); en la tarea no aparece.
        mTextView.get().setText(s);
    }
}
