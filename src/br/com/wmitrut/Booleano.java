package br.com.wmitrut;

import br.com.wmitrut.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class Booleano extends Activity {

	private CheckBox chkA;
	private CheckBox chkB;
	private CheckBox chkC;
	private CheckBox chkD;

	private TextView txvResultado;

	private Button btnCalcular;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_booleano);

		iniciar();
		setarEventos();
	}

	private void setarEventos() {

		btnCalcular.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				iniciarTesteEExibir();
			}
		});
	}

	private void iniciar() {
		chkA = (CheckBox) findViewById(R.id.ckbA);
		chkB = (CheckBox) findViewById(R.id.ckbB);
		chkC = (CheckBox) findViewById(R.id.ckbC);
		chkD = (CheckBox) findViewById(R.id.ckbD);

		txvResultado = (TextView) findViewById(R.id.txvSaidaBooleano);
		btnCalcular = (Button) findViewById(R.id.btnCalcularBooleano);
	}

	private void iniciarTesteEExibir() {
		boolean a = chkA.isChecked();
		boolean b = chkB.isChecked();
		boolean c = chkC.isChecked();
		boolean d = chkD.isChecked();

		boolean valorTestado = testar(a, b, c, d);

		exibir(valorTestado);
	}

	private void exibir(boolean value) {
		String valor = value ? "1" : "0";

		txvResultado.setText(valor);
	}

	private boolean testar(boolean a, boolean b, boolean c, boolean d) {
		return (a && b == c) || (a == d && !(a && b && d));
	}
}
