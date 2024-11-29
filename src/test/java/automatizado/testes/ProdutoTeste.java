package automatizado.testes;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import automatizado.pageObject.ProdutoPO;

public class ProdutoTeste extends BaseTest{
	
	private static ProdutoPO produtoPage;
	
	@BeforeClass
	public static void prepararTestes() {
		produtoPage = new ProdutoPO(driver);
		produtoPage.buttonAdicionar.click();
		produtoPage.buttonAdicionar.click();
	}
	
	
	@Test
	public void TC006_naoDeveCadastrarProdutosComTodosOsCamposVazios() {
		
		produtoPage.inputCodigo.sendKeys("");
		produtoPage.inputNome.sendKeys("");
		produtoPage.inputQuantidade.sendKeys("");
		produtoPage.inputValor.sendKeys("");
		produtoPage.inputData.sendKeys("");
		
		produtoPage.buttonSalvar.click();
		
		String mensagem = produtoPage.obterMensagem();
		
		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
	}
	
	@Test
	public void TC007_naoDeveCadastrarProdutosComOCodigoEDataVazios() {
		
		produtoPage.inputCodigo.sendKeys("");
		produtoPage.inputNome.sendKeys("Camisa");
		produtoPage.inputQuantidade.sendKeys("1");
		produtoPage.inputValor.sendKeys("100");
		produtoPage.inputData.sendKeys("");
		
		produtoPage.buttonSalvar.click();
		
		String mensagem = produtoPage.obterMensagem();
		
		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
	}
	
	@Test
	public void TC008_naoDeveCadastrarProdutosComONomeEDataVazios() {
		
		produtoPage.inputCodigo.sendKeys("500");
		produtoPage.inputNome.sendKeys("");
		produtoPage.inputQuantidade.sendKeys("1");
		produtoPage.inputValor.sendKeys("100");
		produtoPage.inputData.sendKeys("");
		
		produtoPage.buttonSalvar.click();
		
		String mensagem = produtoPage.obterMensagem();
		
		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
	}

}
