package br.com.wmitrut;

import br.com.wmitrut.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Fibonacci extends Activity {

	TextView txvResultado;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fibonacci);

		txvResultado = (TextView) findViewById(R.id.txvResultadoFibo);

		Button btnFibo = (Button) findViewById(R.id.btnCalcularFibo);

		final EditText edtValor = (EditText) findViewById(R.id.edtNesimoElemento);
		btnFibo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Integer numero = Integer
						.parseInt(edtValor.getText().toString());

				calcularEExibirFibo(numero);
			}
		});
	}

	private void calcularEExibirFibo(int nesimo) {
		String valores = "";

		for (int i = 0; i < nesimo; i++) {
			valores += calcularFibo(i) + " ";
		}

		txvResultado.setText(valores + "");
	}

	private int calcularFibo(int num) {
		if (num == 0) {
			return 0;
		} else if (num < 3) {
			return 1;
		}

		return calcularFibo(num - 1) + calcularFibo(num - 2);
	}
}
