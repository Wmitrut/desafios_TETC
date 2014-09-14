package br.com.wmitrut;

import br.com.wmitrut.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Principal extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_principal);

		Button btnFibonnaci = (Button) findViewById(R.id.btnFibonnaci);
		Button btnBooleano = (Button) findViewById(R.id.btnBooleano);
		Button btnArvore = (Button) findViewById(R.id.btnArvore);

		setarEvento(btnFibonnaci, Fibonacci.class);
		setarEvento(btnArvore, Pilha.class);
		setarEvento(btnBooleano, Booleano.class);
	}

	private void setarEvento(Button btn,
			final Class<? extends Activity> classeTela) {

		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				iniciarActivity(classeTela);
			}
		});

	}

	private void iniciarActivity(Class<? extends Activity> classeTela) {
		Intent intent = new Intent(this, classeTela);

		startActivity(intent);
	}

	
}
