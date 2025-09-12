passo a passo de como fazer o CRUD:
Criar a model 



2. Criar o Repository
dentro da interface Repository chamamos com @Repository, ex: public interface ClienteRepository e coloca 
a herança (extends) com o JpaRepository<Cliente, Integer - para representar números inteiros



3. Criar o Service 
dentro da classe Service chamamos o @Service, public class - nome da classe, vamos criar um private final e faz a injeção de Dependencia, chamando o Repository -> public e chamamos o Service(nomeRepository e damos um nome a ele {
this. nomeRepository = nome dado ao Repositor



4. Criar o Controller
dentro da classe Controller - @RestController que é um pedido e resposta e criamos um link pro front-end se conectar ao back-end @RequestMapping ("link"), fazemos a injeção de dependência de controller para o service criamos um private final ClasseService e um nome dado nomeService -> public ClasseController(ClasseService service 

para listar usamos @GetMapping ! para cadastrar usamos @PostMapping ! para Buscar por id @GetMapping e criamos um link ("/{id})  ! para deletar usamos @DeleteMapping e criamos um link ("/{id}) ! para atualizar usamos @PutMapping e criamos um link ("/{id}) 