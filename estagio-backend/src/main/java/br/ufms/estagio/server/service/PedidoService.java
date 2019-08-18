package br.ufms.estagio.server.service;

//import br.ufms.estagio.old.repository.PedidoRepository;

//@Service
//public class PedidoService {


//    @Autowired
//    private PedidoRepository pedidoRepository;

//    public Categoria salvar(Categoria cat1) {
//        return categoriaRepository.save(cat1);
//    }
//    @Transactional
//    public Categoria buscarCategoriaPorId(Long id) {
//
//        Categoria categoria = categoriaRepository.findOne(id);
//
//        if(categoria == null){
//            throw new ObjectNotFountException("O objeto " + Categoria.class.getName() +
//            " com ID: " + id + " não foi encontrado!");
//        }
//
//        return categoria;
//    }
//    public List<Categoria> getCategorias() {
//
//        List<Categoria> categorias = categoriaRepository.findAll();
//
//        if(categorias == null){
//            throw new ObjectNotFountException("O objeto não foi encontrado!");
//        }
//        return categorias;
//    }
//    public List<Categoria> delete(Long id) {
//        Categoria cat = categoriaRepository.getOne(id);
//        cat.getProdutos().forEach(produto ->  produtoRepository.delete(produto.getId()));
//        categoriaRepository.delete(id);
//
//        return categoriaRepository.findAll();
//    }
//}
