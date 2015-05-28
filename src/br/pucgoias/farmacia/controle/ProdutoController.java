package br.pucgoias.farmacia.controle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlInputHidden;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import br.pucgoias.farmacia.entidade.Produto;
import br.pucgoias.farmacia.negocio.ProdutoService;
import br.pucgoias.util.FarmaciaException;



/**
 * @author Fábio Henrique Pires
 * Classe que controla as requisicoes do cliente web
 *
 */
@ManagedBean(name="produtoController")
@RequestScoped
@Controller
public class ProdutoController {

	@Autowired
	private ProdutoBean produtoBean;
	@Autowired
	private List<ProdutoBean> listaProdutoBean;
	@Autowired
	private ProdutoService produtoService;
	
	/**
	 * Construtor da classe de produto
	 */
	@SuppressWarnings("unchecked")
	public ProdutoController(){
		produtoBean = new ProdutoBean();
	}
	
	
	public ProdutoService getProdutoService() {
		return produtoService;
	}

	public void setProdutoService(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
	private FacesContext getFacesContext(){
		return FacesContext.getCurrentInstance();
	}
	
	private Object getSession(String variavel){
		return this.getFacesContext().getExternalContext().getSessionMap().get(variavel);
	}
	
	private void setSession(String variavel, Object objeto){
		this.getFacesContext().getExternalContext().getSessionMap().put(variavel, objeto);
	}
	
	public ProdutoBean getProdutoBean() {
		return produtoBean;
	}

	public void setProdutoBean(ProdutoBean produtoBean) {
		this.produtoBean = produtoBean;
	}

	public List<ProdutoBean> getListaProdutoBean() {
		return listaProdutoBean;
	}

	public void setListaProdutoBean(List<ProdutoBean> listaProdutoBean) {
		this.listaProdutoBean = listaProdutoBean;
	}
	
	/**
	 * Inclui um produto na base de dados
	 * @return
	 */
	public String incluir() {
		try{
			Produto produto = new Produto();
			//preenche os dados da tela no objeto persistente
			produto.setProdId(produtoBean.getProdId());
			produto.setProdNome(produtoBean.getProdNome());
			produto.setProdDescricao(produtoBean.getProdDescricao());
			produto.setProdTarja(produtoBean.getProdTarja());
			produto.setProdDataFabric(produtoBean.getProdDataFabric());
			produto.setProdDataValid(produtoBean.getProdDataValid());
			produto.setProdValor(produtoBean.getProdValor());

			getProdutoService().incluir(produto);
			
			return "sucesso";
		}
		catch (Exception e) {
			String msg = "Inclusao nao realizada. Movito: " + ((e instanceof FarmaciaException ? ((FarmaciaException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}
	
	/**
	 * Lista os produtos cadastrados
	 * @return
	 */
	public String listar() {
		try{

			List<Produto> listaProduto = getProdutoService().listar();

			if(listaProduto==null || listaProduto.size()==0){
				FacesMessage message = new FacesMessage("Nenhum registro encontrado.");
				this.getFacesContext().addMessage("formulario", message);
			}

			//preeche a lista de pessoas da tela
			listaProdutoBean = new ArrayList<ProdutoBean>();
			for (Produto produto : listaProduto) {
				ProdutoBean produtoBean = new ProdutoBean();
				produtoBean.setProdId(produto.getProdId());
				produtoBean.setProdNome(produto.getProdNome());
				produtoBean.setProdDescricao(produto.getProdDescricao());
				produtoBean.setProdTarja(produto.getProdTarja());
				produtoBean.setProdDataFabric(produto.getProdDataFabric());
				produtoBean.setProdDataValid(produto.getProdDataValid());
				produtoBean.setProdValor(produto.getProdValor());
				listaProdutoBean.add(produtoBean);
			}

			return "listar";
		}
		catch (Exception e) {
			String msg = "Listagem nao realizada. Movito: " + ((e instanceof FarmaciaException ? ((FarmaciaException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}
	
	/**
	 * Consulta um produto cadastrado
	 * @return
	 */
	public String consultar() {
		try{

			String prodId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("prodId");
			
			Produto produto = getProdutoService().consultar(Integer.parseInt(prodId));

			if(produto==null || produto.getProdId()==null){
				FacesMessage message = new FacesMessage("Nenhum registro encontrado.");
				this.getFacesContext().addMessage("formulario", message);
				return "listar";
			}

			//preenche os dados do bean da tela
			produtoBean.setProdId(produto.getProdId());
			produtoBean.setProdNome(produto.getProdNome());
			produtoBean.setProdDescricao(produto.getProdDescricao());
			produtoBean.setProdTarja(produto.getProdDescricao());
			produtoBean.setProdDataFabric(produto.getProdDataFabric());
			produtoBean.setProdDataValid(produto.getProdDataValid());
			produtoBean.setProdValor(produto.getProdValor());
			
			return "editar";
		}
		catch (Exception e) {
			String msg = "Consulta nao realizada. Movito: " + ((e instanceof FarmaciaException ? ((FarmaciaException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}
	
	/**
	 * Cria um novo produto
	 * @return
	 */
	public String criar() {
		try{
			produtoBean = new ProdutoBean();
			return "criar";
		}
		catch (Exception e) {
			String msg = "Criacao nao realizada. Movito: " + ((e instanceof FarmaciaException ? ((FarmaciaException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}
	
	/**
	 * Exclui um produto cadastrado
	 * @return
	 */
	public String excluir() {
		try{

			HtmlInputHidden prodId = (HtmlInputHidden) this.getFacesContext().getViewRoot().findComponent("formulario:prodId");
			
			Produto produto = getProdutoService().consultar((Integer)prodId.getValue());

			if(produto==null || produto.getProdId()==null){
				FacesMessage message = new FacesMessage("Nenhum registro encontrado.");
				this.getFacesContext().addMessage("formulario", message);
				return "listar";
			}

			getProdutoService().excluir(produto.getProdId());
			
			return "sucesso";
		}
		catch (Exception e) {
			String msg = "Exclusao nao realizada. Movito: " + ((e instanceof FarmaciaException ? ((FarmaciaException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}
	
	/**
	 * Altera um produto cadastrado
	 * @return
	 */
	public String alterar() {
		try{
			Produto produto = getProdutoService().consultar(produtoBean.getProdId());

			if(produto==null || produto.getProdId()==null){
				FacesMessage message = new FacesMessage("Nenhum registro encontrado.");
				this.getFacesContext().addMessage("formulario", message);
				return "listar";
			}
			//preenche os dados da tela no objeto persistente
			produto.setProdNome(produtoBean.getProdNome());
			produto.setProdDescricao(produtoBean.getProdDescricao());
			produto.setProdTarja(produtoBean.getProdTarja());
			produto.setProdDataFabric(produtoBean.getProdDataFabric());
			produto.setProdDataValid(produtoBean.getProdDataValid());
			produto.setProdValor(produtoBean.getProdValor());

			getProdutoService().alterar(produto);
			return "sucesso";
			
		}
		catch (Exception e) {
			String msg = "Alteracao nao realizada. Movito: " + ((e instanceof FarmaciaException ? ((FarmaciaException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}
}
