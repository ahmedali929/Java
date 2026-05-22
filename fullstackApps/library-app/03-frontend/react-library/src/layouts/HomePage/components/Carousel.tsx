import { ReturnBook } from './ReturnBook'

export const Carousel = () => {
    return (
        <div className="cointainer mt-5" style={{ height: 550 }}>
            <div className="homepage-carousel-title">
                <h3>Fid your next "I stayed up too late reading" book.</h3>
            </div>
            <div id="carouselExampleControls" className="carousel carousel-dark slide mt-5 d-none d-lg-block" data-bs-interval="false">
                {/*Desktop*/}
                <div className="carousel-inner">
                    <div className="carousel-item active">
                        <div className="row d-flex justify-content-center align-items-center">
                            <ReturnBook />
                            <ReturnBook />
                            <ReturnBook />
                        </div>
                    </div>
                    <div className="carousel-item">
                        <div className="row d-flex justify-content-center align-items-center">
                            <ReturnBook />
                            <ReturnBook />
                            <ReturnBook />
                        </div>
                    </div>
                    <div className="carousel-item">
                        <div className="row d-flex justify-content-center align-items-center">
                            <ReturnBook />
                            <ReturnBook />
                            <ReturnBook />
                        </div>
                    </div>
                    </div>
                    <button className="carousel-contorl-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
                        <span className="carosel-contorl-prev-icon" aria-hidden="true"></span>
                        <span className="visually-hidden">Previous</span>
                    </button>
                    <button className="carousel-contorl-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
                        <span className="carosel-contorl-next-icon" aria-hidden="true"></span>
                        <span className="visually-hidden">Next</span>
                    </button>
                </div>
                {/* Mobile */}
                <div className="d-lg-node mt-3">
                    <div className="row d-flex justify-content-center align-items-center">
                        <ReturnBook />
                    </div>   
                </div>
                <div className="homepage-carousel-title mt-3">
                    <a className="btn btn-outline-secondary btn-lg" href="#">View More</a>
                </div>
            </div>
    )
}