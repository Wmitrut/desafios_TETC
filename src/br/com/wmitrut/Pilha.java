package br.com.wmitrut;

import br.com.wmitrut.R;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

public class Pilha extends Activity {

	private Node node = new Node();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pilha);

		criarNode(6, 4, 8, 5, 3, 7, 9);

		LinearLayout root = (LinearLayout) findViewById(R.id.painel_arvore);

		criarArvoreNaTela(node, root);

		Button btnPesquisar = (Button) findViewById(R.id.btnProcurar);

		btnPesquisar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				node.getContainer().setTextColor(Color.RED);

				EditText t = (EditText) findViewById(R.id.edtValor);

				Integer valor = Integer.parseInt(t.getText().toString());
				Toast.makeText(Pilha.this, pesquisar(node, valor) + "",
						Toast.LENGTH_SHORT).show();
			}
		});
	}

	private boolean pesquisar(Node node, int numero) {

		if (node == null) {
			return false;
		}
		
		if(node.getNumero().equals(numero))
		{
			node.getContainer().setTextColor(Color.RED);
			return true;
		}

		boolean encontrouMenor = pesquisar(node.getMenor(), numero);
		boolean encontrouMaior = pesquisar(node.getMaior(), numero);

		if (encontrouMaior || encontrouMenor) {
			node.getContainer().setTextColor(Color.RED);
			
			return true;
		} else {
			node.getContainer().setTextColor(Color.BLACK);
			return false;
		}
	}

	private void criarNode(int... valores) {
		for (int i : valores) {
			node.inserir(i);
		}
	}

	private void criarArvoreNaTela(Node node, LinearLayout root) {
		LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);
		layoutParams.weight = 1;

		LinearLayout lh = new LinearLayout(this);
		lh.setOrientation(LinearLayout.HORIZONTAL);
		lh.setLayoutParams(layoutParams);

		LinearLayout lhL = new LinearLayout(this);
		lhL.setOrientation(LinearLayout.VERTICAL);
		lhL.setLayoutParams(layoutParams);

		LinearLayout lhR = new LinearLayout(this);
		lhR.setOrientation(LinearLayout.VERTICAL);
		lhR.setLayoutParams(layoutParams);

		if (node != null) {
			TextView txvNumero = new TextView(this);
			txvNumero.setText(node.getNumero() + "");

			root.addView(txvNumero);
			node.setContainer(txvNumero);
		}

		root.addView(lh);

		lh.addView(lhL);
		lh.addView(lhR);

		if (node != null) {
			criarArvoreNaTela(node.getMenor(), lhL);
			criarArvoreNaTela(node.getMaior(), lhR);
		}
	}
}
